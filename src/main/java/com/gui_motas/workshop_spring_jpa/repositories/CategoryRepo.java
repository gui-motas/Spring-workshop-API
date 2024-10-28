package com.gui_motas.workshop_spring_jpa.repositories;

import com.gui_motas.workshop_spring_jpa.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Long> {
}
