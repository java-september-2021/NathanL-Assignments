package com.nlangione.ProductsAndCategories.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlangione.ProductsAndCategories.models.Category;
import com.nlangione.ProductsAndCategories.models.Product;
import com.nlangione.ProductsAndCategories.repositories.CategoryRepository;
import com.nlangione.ProductsAndCategories.repositories.ProductRepository;

@Service
public class ProductsService {
	@Autowired
	private ProductRepository productRepo;

	@Autowired
	private CategoryRepository categoryRepo;

	// category methods
	// Get all Categories From Database And Return In ArrayList
	public List<Category> getAllCategories() {
		return this.categoryRepo.findAll();
	}

	public List<Category> getProducts() {
		return this.categoryRepo.findAll();
	}

	// Get One Category
	public Category findCategoryById(Long id) {
		return this.categoryRepo.findById(id).orElse(null);
	}

	// Create Category
	public Category createCategory(Category category) {
		return this.categoryRepo.save(category);
	}

	public void addProductToCategory(Long categoryId, Long productId) {
		// retrieve an instance of a category using another method in the service.
		Category thisCategory = findCategoryById(categoryId);
		System.out.println(thisCategory);
		// retrieve an instance of a product using another method in the service.
		Product thisProduct = findProductById(productId);
		System.out.println(thisProduct);
		// add the product to this category's list of products
		thisCategory.getProducts().add(thisProduct);

		// Save thisCategory, since you made changes to its product list.
		categoryRepo.save(thisCategory);
	}

	public List<Category> findCategoriesNotInProduct(Product product) {
		return this.categoryRepo.findByProductsNotContains(product);
	}

	public void deleteCategory(Long id) {
		this.categoryRepo.deleteById(id);
	}

	// product methods
	// Get all Products From Database And Return In ArrayList
	public List<Product> getAllProducts() {
		return this.productRepo.findAll();
	}

	// Get One Product
	public Product findProductById(Long id) {
		return this.productRepo.findById(id).orElse(null);
	}

	// Create Product
	public Product createProduct(Product product) {
		return this.productRepo.save(product);
	}

	public void addCategoryToProduct(Long categoryId, Long productId) {
		// retrieve an instance of a category using another method in the service.
		Category thisCategory = findCategoryById(categoryId);
		System.out.println(thisCategory);
		// retrieve an instance of a product using another method in the service.
		Product thisProduct = findProductById(productId);
		System.out.println(thisProduct);
		// add the category to this products's list of categories
		thisProduct.getCategories().add(thisCategory);
		// Save thisProduct, since you made changes to its category list.
		productRepo.save(thisProduct);
	}

	public List<Product> findProductsNotInCategory(Category category) {
		return this.productRepo.findByCategoriesNotContains(category);
	}

	public void deleteProduct(Long id) {
		this.productRepo.deleteById(id);
	}
}