package com.gui_motas.workshop_spring_jpa.resources;


import com.gui_motas.workshop_spring_jpa.entities.Order;
import com.gui_motas.workshop_spring_jpa.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/orderS")
public class OrderResource {
    @Autowired
    OrderService orderS;

    @GetMapping
    public ResponseEntity<List<Order>> findAll() {
        List<Order> list = orderS.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id) {
        Order obj = orderS.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Order> deleteById(@PathVariable Long id) {
        orderS.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order obj){
        obj = orderS.update(id, obj);
        return ResponseEntity.ok().body(obj);

    }

    @PostMapping
    public ResponseEntity<Order> insert(@RequestBody Order obj) {
        obj = orderS.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

}