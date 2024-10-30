package com.gui_motas.workshop_spring_jpa.resources;


import com.gui_motas.workshop_spring_jpa.entities.User;
import com.gui_motas.workshop_spring_jpa.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @Autowired
    UserService userS;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> list = userS.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User obj = userS.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userS.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User obj) {
        obj = userS.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj) {
        obj = userS.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

}