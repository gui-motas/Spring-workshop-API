package com.gui_motas.workshop_spring_jpa.repositories;

import com.gui_motas.workshop_spring_jpa.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Long> {
}
