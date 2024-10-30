package com.gui_motas.workshop_spring_jpa.services;

import com.gui_motas.workshop_spring_jpa.entities.User;
import com.gui_motas.workshop_spring_jpa.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;


    public List<User> findAll() {

        return userRepo.findAll();
    }

    public User findById(Long id) {

        return userRepo.findById(id).get();
    }

    public void delete(Long id) {
        userRepo.deleteById(id);
    }

    public User insert(User obj) {
        return userRepo.save(obj);
    }

    public User update(Long id, User obj) {
        User entity = userRepo.getReferenceById(id);
        updateData(entity, obj);
        return userRepo.save(entity);
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }

}
