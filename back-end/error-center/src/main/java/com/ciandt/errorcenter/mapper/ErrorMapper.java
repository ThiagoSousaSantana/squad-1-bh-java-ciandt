package com.ciandt.errorcenter.mapper;

import com.ciandt.errorcenter.domain.model.Error;
import com.ciandt.errorcenter.dto.ErrorDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ErrorMapper {

    ErrorDTO toError(Error error);
    List<ErrorDTO> toError(List<Error> errors);
}
