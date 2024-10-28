package com.gui_motas.workshop_spring_jpa.config;

import com.gui_motas.workshop_spring_jpa.entities.Category;
import com.gui_motas.workshop_spring_jpa.entities.Order;
import com.gui_motas.workshop_spring_jpa.entities.Product;
import com.gui_motas.workshop_spring_jpa.entities.User;
import com.gui_motas.workshop_spring_jpa.entities.enums.OrderStatus;
import com.gui_motas.workshop_spring_jpa.repositories.CategoryRepo;
import com.gui_motas.workshop_spring_jpa.repositories.OrderRepo;
import com.gui_motas.workshop_spring_jpa.repositories.ProductRepo;
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

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ProductRepo productRepo;


    @Override
    public void run(String... args) throws Exception {


        Category cat1 = Category.builder().id(null).name("Electronics").build();
        Category cat2 = Category.builder().id(null).name("Books").build();
        Category cat3 = Category.builder().id(null).name("Computers").build();

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

        User user1 = User.builder().id(null).name("Gui").email("gui@gmail.com").phone("912313651").password("12345").build();
        User user2 = User.builder().id(null).name("Maria").email("maria@gmail.com").phone("912313651").password("1234").build();

        Order o1 = Order.builder().id(null).moment(Instant.parse("2019-06-20T19:53:07Z")).orderStatus(OrderStatus.DELIVERED).client(user1).build();
        Order o2 = Order.builder().id(null).moment(Instant.parse("2019-07-21T03:42:10Z")).orderStatus(OrderStatus.SHIPPED).client(user2).build();
        Order o3 = Order.builder().id(null).moment(Instant.parse("2019-07-22T15:21:22Z")).orderStatus(OrderStatus.WAITING_PAYMENT).client(user1).build();

        userRepo.saveAll(Arrays.asList(user1, user2));
        orderRepo.saveAll(Arrays.asList(o1, o2, o3));
        categoryRepo.saveAll(Arrays.asList(cat1, cat2, cat3));
        productRepo.saveAll(Arrays.asList(p1, p2, p3,p4,p5));
    }
}
