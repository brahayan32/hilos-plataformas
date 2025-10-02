package com.plataformas.hilos.controllers;

import com.plataformas.hilos.model.ConcertEntity;
import com.plataformas.hilos.services.ConcertService;
import com.plataformas.hilos.services.TicketGeneratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/concerts")
@RequiredArgsConstructor
public class ConcertController {

    private final ConcertService concertService;
    private final TicketGeneratorService ticketGeneratorService;

    @GetMapping
    public List<ConcertEntity> getAll() {
        return concertService.getAll();
    }

    @PostMapping
    public ConcertEntity create(@RequestBody ConcertEntity concert) {
        return concertService.save(concert);
    }

    @PostMapping("/{id}/generate-tickets")
    public ResponseEntity<String> generarTickets(@PathVariable Long id, @RequestParam int cantidad) {
        ConcertEntity concierto = concertService.getById(id).orElseThrow();
        ticketGeneratorService.generarBoletos(concierto, cantidad);
        return ResponseEntity.ok("Generación de boletos iniciada con " + cantidad + " hilos.");
    }
}