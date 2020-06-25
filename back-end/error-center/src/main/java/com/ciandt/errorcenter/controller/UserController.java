package com.ciandt.errorcenter.controller;

import com.ciandt.errorcenter.domain.model.User;
import com.ciandt.errorcenter.dto.UserDTO;
import com.ciandt.errorcenter.event.CreatedRegisterEvent;
import com.ciandt.errorcenter.mapper.UserMapper;
import com.ciandt.errorcenter.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.var;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;
    private final ApplicationEventPublisher publisher;

    @GetMapping
    @ApiOperation(value = "List all registered users", produces = "application/json")
    @ApiResponses(@ApiResponse(code = 200, message = "Successfully listed users", response = UserDTO.class, responseContainer = "List"))
    public List<UserDTO> getAll(@RequestParam(defaultValue = "0") Integer page,
                                @RequestParam(defaultValue = "20") Integer size,
                                @RequestParam(defaultValue = "email") String property,
                                @RequestParam(defaultValue = "ASC") Sort.Direction direction) {

        return userMapper.toUser(userService.getAll(PageRequest.of(page, size, direction, property)).getContent());
    }

    @PostMapping
    @ApiOperation(value = "Register a new user", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "User registered successfully", response = UserDTO.class),
            @ApiResponse(code = 400, message = "User registration failed")
    })
    public ResponseEntity<User> post(@RequestBody @Valid UserDTO userDTO, HttpServletResponse response) {
        var user = userService.save(userMapper.toUser(userDTO, UUID.randomUUID()));
        publisher.publishEvent(new CreatedRegisterEvent(this, response, user.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

}
