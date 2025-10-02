package com.plataformas.hilos.controllers;

import com.plataformas.hilos.model.OrchestraEntity;
import com.plataformas.hilos.services.OrchestraService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orchestras")
@RequiredArgsConstructor
public class OrchestraController {

    private final OrchestraService service;

    @GetMapping
    public List<OrchestraEntity> getAll() {
        return service.getAll();
    }

    @PostMapping
    public OrchestraEntity create(@RequestBody OrchestraEntity orchestra) {
        return service.save(orchestra);
    }
}