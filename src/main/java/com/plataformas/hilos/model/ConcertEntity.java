package com.plataformas.hilos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "concerts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConcertEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;
    private String country;
    private Integer year;
    private BigDecimal rating;

    @ManyToOne
    @JoinColumn(name = "orchestra_id")
    private OrchestraEntity orchestra;

    @OneToMany(mappedBy = "concert", cascade = CascadeType.ALL)
    private List<TicketEntity> tickets;
}