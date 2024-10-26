package com.gui_motas.workshop_spring_jpa.entities;

import lombok.*;


import java.io.Serializable;

public @Data @AllArgsConstructor @NoArgsConstructor class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String email;
    private String phone;
    private String password;
}