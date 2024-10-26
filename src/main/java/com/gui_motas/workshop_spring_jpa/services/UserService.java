package com.gui_motas.workshop_spring_jpa.services;

import com.gui_motas.workshop_spring_jpa.entities.User;
import com.gui_motas.workshop_spring_jpa.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;


    public List<User> findAll() {
        return userRepo.findAll();
    }

    public User findById(Long id) {
        Optional<User> obj = userRepo.findById(id);
        return obj.get();
    }
}
