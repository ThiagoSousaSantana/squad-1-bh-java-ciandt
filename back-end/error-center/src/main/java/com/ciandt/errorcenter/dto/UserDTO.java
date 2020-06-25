package com.ciandt.errorcenter.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private UUID id;

    @Email
    @NotNull
    @Size(min = 3, max = 150)
    private String email;

    @NotNull
    @Size(min = 3, max = 100)
    private String password;

}
