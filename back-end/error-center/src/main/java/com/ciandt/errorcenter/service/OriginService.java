package com.ciandt.errorcenter.service;

import com.ciandt.errorcenter.domain.model.Origin;
import com.ciandt.errorcenter.repository.OriginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@Service
public class OriginService {

    @Autowired
    private OriginRepository originRepository;

    public Origin save(@Valid Origin origin) {
        return originRepository.save(origin);
    }

    public Optional<Origin> getById(UUID id) {
        return originRepository.findById(id);
    }

    public Page<Origin> getAll(Pageable pageable) {
        return originRepository.findAll(pageable);
    }

}
