package com.gui_motas.workshop_spring_jpa.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_product")
public @Data @AllArgsConstructor @Builder @NoArgsConstructor class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    private String name;
    private @EqualsAndHashCode.Exclude String description;
    private @EqualsAndHashCode.Exclude Double price;
    private @EqualsAndHashCode.Exclude String imgUrl;

    @ManyToMany
    @JoinTable(name = "tb_product_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    @Setter(AccessLevel.NONE) // Exclui do builder
    private Set<Category> categories = new HashSet<>();

    public static class ProductBuilder {
        public Product build() {
            if (this.categories == null) {
                this.categories = new HashSet<>(); // Garante um Set vazio
            }
            return new Product(id, name, description, price, imgUrl, categories);
        }
    }
}

