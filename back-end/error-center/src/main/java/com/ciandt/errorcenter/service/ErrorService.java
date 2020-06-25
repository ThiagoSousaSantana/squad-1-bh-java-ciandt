package com.ciandt.errorcenter.service;

import com.ciandt.errorcenter.domain.model.Error;
import com.ciandt.errorcenter.repository.ErrorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@Service
public class ErrorService {

    @Autowired
    private ErrorRepository errorRepository;

    public Error save(@Valid Error error) {
        return errorRepository.save(error);
    }

    public Optional<Error> getById(UUID id) {
        return errorRepository.findById(id);
    }

    public Page<Error> getAll(Pageable pageable) {
        return errorRepository.findAll(pageable);
    }
}
