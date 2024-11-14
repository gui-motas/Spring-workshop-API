package com.gui_motas.workshop_spring_jpa.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_category")
public @Data @Builder @AllArgsConstructor @NoArgsConstructor class Category implements Serializable {

    private static final long serialVersionUID = 1L;
    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    private @EqualsAndHashCode.Exclude String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "categories")
    private @EqualsAndHashCode.Exclude @Setter(AccessLevel.NONE) Set<Product> products = new HashSet<>();

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
