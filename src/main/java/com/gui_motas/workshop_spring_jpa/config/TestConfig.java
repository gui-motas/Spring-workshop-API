package com.gui_motas.workshop_spring_jpa.config;

import com.gui_motas.workshop_spring_jpa.entities.Order;
import com.gui_motas.workshop_spring_jpa.entities.User;
import com.gui_motas.workshop_spring_jpa.entities.enums.OrderStatus;
import com.gui_motas.workshop_spring_jpa.repositories.OrderRepo;
import com.gui_motas.workshop_spring_jpa.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private OrderRepo orderRepo;

    @Override
    public void run(String... args) throws Exception {


        User user1 = User.builder().id(null).name("Gui").email("gui@gmail.com").phone("912313651").password("12345").build();
        User user2 = User.builder().id(null).name("Maria").email("maria@gmail.com").phone("912313651").password("1234").build();

        Order o1 = Order.builder().id(null).moment(Instant.parse("2019-06-20T19:53:07Z")).orderStatus(OrderStatus.DELIVERED).client(user1).build();
        Order o2 = Order.builder().id(null).moment(Instant.parse("2019-07-21T03:42:10Z")).orderStatus(OrderStatus.SHIPPED).client(user2).build();
        Order o3 = Order.builder().id(null).moment(Instant.parse("2019-07-22T15:21:22Z")).orderStatus(OrderStatus.WAITING_PAYMENT).client(user1).build();

        userRepo.saveAll(Arrays.asList(user1, user2));
        orderRepo.saveAll(Arrays.asList(o1, o2, o3));
    }
}
