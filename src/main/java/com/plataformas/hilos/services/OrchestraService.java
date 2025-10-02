package com.plataformas.hilos.services;

import com.plataformas.hilos.model.OrchestraEntity;
import com.plataformas.hilos.repository.OrchestraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrchestraService {
    private final OrchestraRepository repository;

    public List<OrchestraEntity> getAll() {
        return repository.findAll();
    }

    public OrchestraEntity save(OrchestraEntity orchestra) {
        return repository.save(orchestra);
    }
}