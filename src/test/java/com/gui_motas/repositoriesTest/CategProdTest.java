package com.gui_motas.repositoriesTest;


import com.gui_motas.workshop_spring_jpa.WorkshopSpringJpaApplication;
import com.gui_motas.workshop_spring_jpa.entities.*;
import com.gui_motas.workshop_spring_jpa.repositories.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest; //

import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = WorkshopSpringJpaApplication.class)
public class CategProdTest {


	@Autowired
	private ProductRepo productRepo;

	@Autowired
	private CategoryRepo categoryRepo;

	private Product product;
	private Category category;

	@BeforeEach
	public void setUp() {
		// Cria e salva uma cateogria
		category = new Category(null, "Test Category");
		categoryRepo.save(category);

		// Criar e salvar um produto vinculado à categoria
		product = new Product(null, "Test Product", "Description", 100.0, "imgUrl");
		product.getCategories().add(category);
		productRepo.save(product);
	}

	@Test
	void testProductBelongsToCategory {
		// Recuperar o produto do repositório
		Optional<Product> produtoEncontrado = productRepo.findById(product.getId());
		assertTrue(produtoEncontrado.isPresent());

		// Verificar se o produto possui a categoria esperada
		assertFalse(produtoEncontrado.get().getCategories().isEmpty());
		assertTrue(produtoEncontrado.get().getCategories().contains(category));
	}

}
