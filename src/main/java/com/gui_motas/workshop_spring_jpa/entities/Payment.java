package com.gui_motas.workshop_spring_jpa.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "tb_payment")
public @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode @ToString class Payment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private @EqualsAndHashCode.Exclude Instant moment;

    @OneToOne
    @MapsId
    private @EqualsAndHashCode.Exclude Order order;

}
