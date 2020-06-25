package com.ciandt.errorcenter.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "error", schema = "public")
public class Error {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;

    @NotNull
    @Enumerated(EnumType.ORDINAL)
    private Environment environment;

    @NotNull
    @Enumerated(EnumType.ORDINAL)
    private Level level;

    @NotNull
    private LocalDateTime timestamp;

    @NotNull
    @Size(min = 3, max = 150)
    private String title;

    @NotNull
    @Size(min = 3, max = 255)
    private String details;

    @ManyToOne
    @JoinColumn(name = "origin_id")
    private Origin origin;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
