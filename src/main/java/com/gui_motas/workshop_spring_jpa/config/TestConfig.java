package com.gui_motas.workshop_spring_jpa.config;

import com.gui_motas.workshop_spring_jpa.entities.*;
import com.gui_motas.workshop_spring_jpa.entities.enums.OrderStatus;
import com.gui_motas.workshop_spring_jpa.repositories.*;
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

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private OrderItemRepo orderItemRepo;


    @Override
    public void run(String... args) throws Exception {


        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        categoryRepo.saveAll(Arrays.asList(cat1, cat2, cat3));

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum", 90.5, "https://raw.githubusercontent.com/devsuperior/sds2/master/assets/donut.jpg");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "https://raw.githubusercontent.com/devsuperior/sds2/master/assets/donut.jpg");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "https://raw.githubusercontent.com/devsuperior/sds2/master/assets/donut.jpg");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "https://raw.githubusercontent.com/devsuperior/sds2/master/assets/donut.jpg");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "https://raw.githubusercontent.com/devsuperior/sds2/master/assets/donut.jpg");

        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p3.getCategories().add(cat3);
        p3.getCategories().add(cat1);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat2);

        productRepo.saveAll(Arrays.asList(p1, p2, p3,p4,p5));

        User user1 = new User(null, "Gui", "gui@gmail.com", "912313651", "12345");
        User user2 = new User(null, "Maria", "maria@gmail.com", "912313651", "1234");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, user1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, user2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, user1);


        userRepo.saveAll(Arrays.asList(user1, user2));
        orderRepo.saveAll(Arrays.asList(o1, o2, o3));
        
        OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
        OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
        OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
        OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());

        orderItemRepo.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));

        Payment pay1 = new Payment(null, Instant.parse("2019-06-20T21:53:07Z"), o1);
        o1.setPayment(pay1);

        orderRepo.save(o1);

    }
}
