package com.gui_motas.workshop_spring_jpa.services;

import com.gui_motas.workshop_spring_jpa.entities.User;
import com.gui_motas.workshop_spring_jpa.repositories.UserRepo;
import com.gui_motas.workshop_spring_jpa.services.exceptions.DatabaseException;
import com.gui_motas.workshop_spring_jpa.services.exceptions.ResourceNotFoundException;

import jakarta.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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

        return userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public void delete(Long id) {
        if (userRepo.existsById(id)) {
            try{
            userRepo.deleteById(id);
            } catch (DataIntegrityViolationException e) {
                throw new DatabaseException(e.getMessage());
            }

        } else {
            throw new ResourceNotFoundException(id);

        }

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