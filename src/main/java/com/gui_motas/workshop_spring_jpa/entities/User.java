package com.gui_motas.workshop_spring_jpa.entities;

import jakarta.persistence.*;
import lombok.*;


import java.io.Serializable;
@Entity @Table(name = "tb_user")
public @Data @AllArgsConstructor @NoArgsConstructor class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    private String name;
    private String email;
    private String phone;
    private String password;
}