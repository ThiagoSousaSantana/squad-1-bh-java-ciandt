package com.ciandt.errorcenter.service;

import com.ciandt.errorcenter.domain.model.User;
import com.ciandt.errorcenter.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.var;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User save(@Valid User user) {

        user.setToken(generateToken(user.getId().toString(), user.getEmail()));

        return userRepository.save(user);
    }

    public Optional<User> getById(UUID id) {
        return userRepository.findById(id);
    }

    public Page<User> getAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    private String generateToken(String id, String email) {
        var token = id + ":" + email;
        try {
            var messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(token.getBytes(StandardCharsets.UTF_8));
            token = new String(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return token;
    }
}
