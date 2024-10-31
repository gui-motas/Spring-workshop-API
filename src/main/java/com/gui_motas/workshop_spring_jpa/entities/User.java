package com.gui_motas.workshop_spring_jpa.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity @Table(name = "tb_user")
public @Getter @Setter @EqualsAndHashCode @NoArgsConstructor @AllArgsConstructor(access = AccessLevel.PRIVATE) @Builder class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    private String name;
    private @EqualsAndHashCode.Exclude String email;
    private @EqualsAndHashCode.Exclude String phone;

    private @EqualsAndHashCode.Exclude String password;

    @JsonIgnore
    @OneToMany(mappedBy = "client")
    private @EqualsAndHashCode.Exclude @Setter(AccessLevel.NONE) List<Order> orders = new ArrayList<>();

}