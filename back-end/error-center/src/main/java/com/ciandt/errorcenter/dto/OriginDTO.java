package com.ciandt.errorcenter.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OriginDTO {

    private UUID id;

    @NotNull
    @Size(min = 3, max = 150)
    private String name;

    @NotNull
    private UUID user_id;
}
