package com.gui_motas.workshop_spring_jpa.repositories;

import com.gui_motas.workshop_spring_jpa.entities.OrderItem;
import com.gui_motas.workshop_spring_jpa.entities.pk.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepo extends JpaRepository<OrderItem, OrderItemPK> {

}
