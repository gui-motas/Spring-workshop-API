package com.gui_motas.workshop_spring_jpa.resources;


import com.gui_motas.workshop_spring_jpa.entities.User;
import com.gui_motas.workshop_spring_jpa.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @Autowired
    UserRepo userRepo;

@GetMapping
    public ResponseEntity<List<User>> findAll() {
       List<User> user = userRepo.findAll();

        return ResponseEntity.ok().body(user);
    }
}