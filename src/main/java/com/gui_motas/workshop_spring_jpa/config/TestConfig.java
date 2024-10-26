package com.gui_motas.workshop_spring_jpa.config;

import com.gui_motas.workshop_spring_jpa.entities.User;
import com.gui_motas.workshop_spring_jpa.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import java.util.*;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepo userRepo;


    @Override
    public void run(String... args) throws Exception {
        User user1 = new User(null, "Gui", "gui@gmail.com","912313651" ,"1234");
        User user2 = new User(null, "Maria", "maria@gmail.com", "981237182", "12345");

        userRepo.saveAll(Arrays.asList(user1, user2));
    }
}
