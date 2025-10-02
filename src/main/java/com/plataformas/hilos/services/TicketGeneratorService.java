package com.plataformas.hilos.services;

import com.plataformas.hilos.model.ConcertEntity;
import com.plataformas.hilos.model.TicketEntity;
import com.plataformas.hilos.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
@RequiredArgsConstructor
public class TicketGeneratorService {

    private final TicketRepository ticketRepository;

    public void generarBoletos(ConcertEntity concierto, int cantidad) {
        long inicioTotal = System.nanoTime(); // ⏱️ Marca de inicio total

        ExecutorService executor = Executors.newFixedThreadPool(5); // 5 hilos

        for (int i = 1; i <= cantidad; i++) {
            int finalI = i;
            executor.submit(() -> {
                long inicioBoleto = System.nanoTime(); // ⏱️ Inicio por boleto

                TicketEntity ticket = new TicketEntity();
                ticket.setBuyerName("Pendiente");
                ticket.setSeatNumber("A-" + finalI);
                ticket.setPrice(100);
                ticket.setConcert(concierto);
                ticketRepository.save(ticket);

                long finBoleto = System.nanoTime(); // ⏱️ Fin por boleto
                double duracionBoletoSeg = (finBoleto - inicioBoleto) / 1_000_000_000.0;

                System.out.println("🎫 [" + Thread.currentThread().getName() + "] Boleto generado: " + ticket.getSeatNumber()
                        + " en " + String.format("%.3f", duracionBoletoSeg) + " segundos");
            });
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
            // Espera a que todos los hilos terminen
        }

        long finTotal = System.nanoTime(); // ⏱️ Marca de fin total
        double duracionTotalSeg = (finTotal - inicioTotal) / 1_000_000_000.0;

        System.out.println("⏱️ Tiempo total de generación: " + String.format("%.3f", duracionTotalSeg) + " segundos");
    }
}