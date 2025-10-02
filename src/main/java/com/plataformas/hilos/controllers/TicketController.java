package com.plataformas.hilos.controllers;

import com.plataformas.hilos.model.TicketEntity;
import com.plataformas.hilos.services.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService service;

    @GetMapping
    public List<TicketEntity> getAll() {
        return service.getAll();
    }

    @PostMapping
    public TicketEntity create(@RequestBody TicketEntity ticket) {
        return service.save(ticket);
    }
}