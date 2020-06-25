package com.ciandt.errorcenter.domain.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "user", schema = "public")
public class User {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;

    @Email
    @NotNull
    @Size(min = 3, max = 150)
    private String email;

    @NotNull
    @Size(min = 3, max = 100)
    private String password;

    @NotNull
    @Size(max = 255)
    private String token;

    @OneToMany(mappedBy = "user")
    private List<Error> errors;

    @OneToMany(mappedBy = "user")
    private List<Origin> origins;
}
