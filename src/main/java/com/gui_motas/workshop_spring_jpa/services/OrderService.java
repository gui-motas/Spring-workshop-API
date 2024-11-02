package com.gui_motas.workshop_spring_jpa.services;

import com.gui_motas.workshop_spring_jpa.entities.Order;
import com.gui_motas.workshop_spring_jpa.entities.User;
import com.gui_motas.workshop_spring_jpa.repositories.OrderRepo;
import com.gui_motas.workshop_spring_jpa.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
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

    public Order update(Long id, Order obj) {
        try {
            Order entity = orderRepo.getReferenceById(id);
            updateData(entity, obj);
            return orderRepo.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

   private void updateData(Order entity, Order obj){
        entity.setOrderStatus(obj.getOrderStatus());
    }

    public Order insert(Order obj){
        return orderRepo.save(obj);

    }
}
