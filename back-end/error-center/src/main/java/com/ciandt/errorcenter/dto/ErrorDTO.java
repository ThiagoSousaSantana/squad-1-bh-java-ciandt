package com.ciandt.errorcenter.dto;

import com.ciandt.errorcenter.domain.model.Environment;
import com.ciandt.errorcenter.domain.model.Level;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDTO {

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

    @NotNull
    private UUID origin_id;

    @NotNull
    private UUID user_id;
}
