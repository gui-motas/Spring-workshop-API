package com.gui_motas.workshop_spring_jpa.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Tolerate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity @Table(name = "tb_user")
public @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    private String name;
    private String email;
    private String phone;
    private @ToString.Exclude String password;
    @OneToMany(mappedBy = "client")
    private  @Setter(AccessLevel.NONE) List<Order> orders = new ArrayList<>();


}