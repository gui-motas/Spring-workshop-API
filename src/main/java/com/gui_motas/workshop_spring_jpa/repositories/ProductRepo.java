package com.gui_motas.workshop_spring_jpa.repositories;

import com.gui_motas.workshop_spring_jpa.entities.Category;
import com.gui_motas.workshop_spring_jpa.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {
}
