package com.gui_motas.workshop_spring_jpa.resources;


import com.gui_motas.workshop_spring_jpa.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
@GetMapping
    public ResponseEntity<User> findAll() {
        User user1 = new User(1L,"Gui", "gui@gmail.com","999999999", "12345");

        return ResponseEntity.ok().body(user1);
    }
}