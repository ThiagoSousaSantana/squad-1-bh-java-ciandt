package com.ciandt.errorcenter.mapper;

import com.ciandt.errorcenter.domain.model.Origin;
import com.ciandt.errorcenter.dto.OriginDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OriginMapper {

    OriginDTO toOrigin(Origin origin);
    List<OriginDTO> toOrigin(List<Origin> origins);
}
