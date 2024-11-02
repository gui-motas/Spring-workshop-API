package com.gui_motas.workshop_spring_jpa.services;

import com.gui_motas.workshop_spring_jpa.entities.Product;
import com.gui_motas.workshop_spring_jpa.repositories.ProductRepo;
import com.gui_motas.workshop_spring_jpa.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;

    public List<Product> findAll() {
        return productRepo.findAll();
    }

    public Product findById(Long id) {
        return productRepo.findById(id).get();
    }

    public void delete(Long id) {
        productRepo.deleteById(id);
    }

    public Product update(Long id, Product obj) {
        try {
            Product entity = productRepo.getReferenceById(id);
            updateData(entity, obj);
            return productRepo.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    public Product insert(Product obj){
        return productRepo.save(obj);
    }

    private void updateData(Product entity, Product obj) {
        entity.setName(obj.getName());
        entity.setDescription(obj.getDescription());
        entity.setPrice(obj.getPrice());
        entity.setImgUrl(obj.getImgUrl());
    }
}
