package com.ciandt.errorcenter.repository;

import com.ciandt.errorcenter.domain.model.Origin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OriginRepository extends JpaRepository<Origin, UUID> {
}
