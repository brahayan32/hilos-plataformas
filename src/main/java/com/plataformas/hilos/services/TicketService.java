package com.plataformas.hilos.services;

import com.plataformas.hilos.model.TicketEntity;
import com.plataformas.hilos.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository repository;

    public List<TicketEntity> getAll() {
        return repository.findAll();
    }

    public TicketEntity save(TicketEntity ticket) {
        return repository.save(ticket);
    }
}