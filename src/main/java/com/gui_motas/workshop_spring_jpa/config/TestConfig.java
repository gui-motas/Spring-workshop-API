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


        Category cat1 = Category.builder().id(null).name("Electronics").build();
        Category cat2 = Category.builder().id(null).name("Books").build();
        Category cat3 = Category.builder().id(null).name("Computers").build();

        categoryRepo.saveAll(Arrays.asList(cat1, cat2, cat3));

        Product p1 = Product.builder().id(null).name("The Lord of the Rings").description("Lorem ipsum").price(90.5).imgUrl("https://raw.githubusercontent.com/devsuperior/sds2/master/assets/donut.jpg").build();
        Product p2 = Product.builder().id(null).name("Smart TV").description("Nulla eu imperdiet purus. Maecenas ante.").price(2190.0).imgUrl("https://raw.githubusercontent.com/devsuperior/sds2/master/assets/donut.jpg").build();
        Product p3 = Product.builder().id(null).name("Macbook Pro").description("Nam eleifend maximus tortor, at mollis.").price(1250.0).imgUrl("https://raw.githubusercontent.com/devsuperior/sds2/master/assets/donut.jpg").build();
        Product p4 = Product.builder().id(null).name("PC Gamer").description("Donec aliquet odio ac rhoncus cursus.").price(1200.0).imgUrl("https://raw.githubusercontent.com/devsuperior/sds2/master/assets/donut.jpg").build();
        Product p5 = Product.builder().id(null).name("Rails for Dummies").description("Cras fringilla convallis sem vel faucibus.").price(100.99).imgUrl("https://raw.githubusercontent.com/devsuperior/sds2/master/assets/donut.jpg").build();

        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p3.getCategories().add(cat3);
        p3.getCategories().add(cat1);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat2);

        productRepo.saveAll(Arrays.asList(p1, p2, p3,p4,p5));

        User user1 = User.builder().id(null).name("Gui").email("gui@gmail.com").phone("912313651").password("12345").build();
        User user2 = User.builder().id(null).name("Maria").email("maria@gmail.com").phone("912313651").password("1234").build();

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
    }
}
