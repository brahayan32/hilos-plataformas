package com.plataformas.hilos.services;

import com.plataformas.hilos.model.ConcertEntity;
import com.plataformas.hilos.repository.ConcertRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ConcertService {

    private final ConcertRepository repository;

    public List<ConcertEntity> getAll() {
        return repository.findAll();
    }

    public ConcertEntity save(ConcertEntity concert) {
        return repository.save(concert);
    }
    public Optional<ConcertEntity> getById(Long id) {
        return repository.findById(id);
    }
}