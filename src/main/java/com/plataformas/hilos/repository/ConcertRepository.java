package com.plataformas.hilos.repository;

import com.plataformas.hilos.model.ConcertEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConcertRepository extends JpaRepository<ConcertEntity, Long> {
}