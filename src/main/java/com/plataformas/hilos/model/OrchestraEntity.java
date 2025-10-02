package com.plataformas.hilos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "orchestras")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrchestraEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "city_origin", nullable = false)
    private String cityOrigin;

    @Column(name = "country_origin", nullable = false)
    private String countryOrigin;

    @Column(nullable = false, precision = 3, scale = 2)
    private BigDecimal rating;

    @OneToMany(mappedBy = "orchestra", cascade = CascadeType.ALL)
    private List<ConcertEntity> concerts;

    @OneToMany(mappedBy = "orchestra", cascade = CascadeType.ALL)
    private List<MemberEntity> members;

}