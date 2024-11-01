package com.gui_motas.workshop_spring_jpa.services;

import com.gui_motas.workshop_spring_jpa.entities.Category;
import com.gui_motas.workshop_spring_jpa.repositories.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import com.gui_motas.workshop_spring_jpa.services.exceptions.ResourceNotFoundException;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepo categoryRepo;

    public List<Category> findAll() {
        return categoryRepo.findAll();
    }

    public Category findById(Long id) {
        return categoryRepo.findById(id).get();
    }

    public void delete(Long id) {
        categoryRepo.deleteById(id);
    }

    public Category updateName(Long id, Category obj) {
        try {
            Category entity = categoryRepo.getReferenceById(id);
            entity.setName(obj.getName());
            return categoryRepo.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }
}