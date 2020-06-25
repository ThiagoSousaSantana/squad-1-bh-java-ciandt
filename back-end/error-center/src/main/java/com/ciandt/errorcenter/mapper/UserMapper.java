package com.ciandt.errorcenter.mapper;

import com.ciandt.errorcenter.domain.model.User;
import com.ciandt.errorcenter.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toUser(User user);

    @Mapping(source = "id", target = "id")
    User toUser(UserDTO userDTO, UUID id);

    List<UserDTO> toUser(List<User> users);
}
