package com.nlangione.ProductsAndCategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nlangione.ProductsAndCategories.models.Category;
import com.nlangione.ProductsAndCategories.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	// this method retrieves all the Products from the database
	List<Product> findAll();

	List<Product> findByCategoriesNotContains(Category category);

}
