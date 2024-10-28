package com.gui_motas.workshop_spring_jpa.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_category")
public @Data @Builder @AllArgsConstructor @NoArgsConstructor class Category {

    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    private @EqualsAndHashCode.Exclude String name;


}
