package com.gui_motas.repositoriesTest;


import com.gui_motas.workshop_spring_jpa.WorkshopSpringJpaApplication;
import com.gui_motas.workshop_spring_jpa.entities.*;
import com.gui_motas.workshop_spring_jpa.entities.enums.OrderStatus;
import com.gui_motas.workshop_spring_jpa.repositories.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest; //

import java.time.Instant;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = WorkshopSpringJpaApplication.class)
public class OrderRepoTest {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private OrderItemRepo orderItemRepo;

    private User user;
    private Order order;

    @BeforeEach
    public void setUp() {

        user = new User(null, "Test User", "testuser@example.com", "123456789", "123");
        userRepo.save(user);

        order = new Order(null, Instant.now(), OrderStatus.PAID, user);
        orderRepo.save(order);
    }

    @Test
    public void testOrderIsLinkedToClient() {
        Optional<Order> foundOrder = orderRepo.findById(order.getId());
        assertTrue(foundOrder.isPresent());
        assertNotNull(foundOrder.get().getClient());
    }

    @Test
    public void testAllAttributesAreCreatedOrInstantiated() {
        assertNotNull(order.getId());
        assertNotNull(order.getMoment());
        assertNotNull(order.getOrderStatus());
        assertNotNull(order.getClient());
        assertNotNull(order.getItems());
    }
}