package com.gui_motas.workshop_spring_jpa.services;

import com.gui_motas.workshop_spring_jpa.entities.Order;
import com.gui_motas.workshop_spring_jpa.repositories.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    OrderRepo OrderRepo;


    public List<Order> findAll() {
        return OrderRepo.findAll();
    }

    public Order findById(Long id) {
        Optional<Order> obj = OrderRepo.findById(id);
        return obj.get();
    }

}
