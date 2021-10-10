package com.nlangione.ProductsAndCategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.nlangione.ProductsAndCategories.models.Category;
import com.nlangione.ProductsAndCategories.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
	// this method retrieves all the Products from the database
	List<Product> findAll();

	List<Product> findByCategoriesNotContains(Category category);

}
