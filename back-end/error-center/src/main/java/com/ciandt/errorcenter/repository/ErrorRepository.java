package com.ciandt.errorcenter.repository;

import com.ciandt.errorcenter.domain.model.Error;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ErrorRepository extends JpaRepository<Error, UUID> {
}
