package com.gui_motas.workshop_spring_jpa.services;

import com.gui_motas.workshop_spring_jpa.entities.Order;
import com.gui_motas.workshop_spring_jpa.repositories.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepo orderRepo;


    public List<Order> findAll() {
        return orderRepo.findAll();
    }

    public Order findById(Long id) {

        return orderRepo.findById(id).get();
    }

    public void delete(Long id) {
        orderRepo.deleteById(id);
    }

}
