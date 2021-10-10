package com.nlangione.ProductsAndCategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nlangione.ProductsAndCategories.models.Category;
import com.nlangione.ProductsAndCategories.models.Product;
import com.nlangione.ProductsAndCategories.services.ProductsService;

@Controller
public class ProductsController {
	@Autowired
	private ProductsService aService;

	// landing methods/routes
	@GetMapping("")
	public String root() {
		return "redirect:/landing";

	}

	@GetMapping("/landing")
	public String index(@ModelAttribute("product") Product product, @ModelAttribute("category") Category category,
			Model viewModel) {
		viewModel.addAttribute("allProducts", this.aService.getAllProducts());
		viewModel.addAttribute("allCategories", this.aService.getAllCategories());
		return "index.jsp";
	}

	// product methods/routes
	@GetMapping("/products/{id}")
	public String viewProduct(@PathVariable("id") Long id, @ModelAttribute("product") Product product,
			Model viewModel) {
		Product productSelected = aService.findProductById(id);
		List<Category> categoriesListed = productSelected.getCategories();
		List<Category> categoriesNotListed = aService.findCategoriesNotInProduct(productSelected);

		viewModel.addAttribute("product", productSelected);
		viewModel.addAttribute("categoriesListed", categoriesListed);
		viewModel.addAttribute("categoriesNotListed", categoriesNotListed);
		return "viewProduct.jsp";
	}

	@PostMapping("/products/{id}")
	public String addCategorytoproduct(@PathVariable("id") Long id, @ModelAttribute("product") Product product,
			@RequestParam("category") Long category, Model viewModel) {
		System.out.println(category);
		this.aService.addCategoryToProduct(category, id);
		return "redirect:/products/" + id;
	}

	@GetMapping("/products/new")
	public String newProduct(@ModelAttribute("product") Product product, Model viewModel) {
		return "newProduct.jsp";
	}

	@PostMapping("/products/new")
	public String addproduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if (result.hasErrors()) {
			return "newProduct.jsp";
		}
		this.aService.createProduct(product);
		return "redirect:/landing";
	}

	// category methods/routes
	@GetMapping("/categories/{id}")
	public String viewCategory(@PathVariable("id") Long id, @ModelAttribute("category") Category category,
			Model model) {
		Category categorySelected = aService.findCategoryById(id);
		List<Product> productsListed = categorySelected.getProducts();
		List<Product> productsNotListed = aService.findProductsNotInCategory(categorySelected);

		model.addAttribute("category", categorySelected);
		model.addAttribute("productsListed", productsListed);
		model.addAttribute("productsNotListed", productsNotListed);
		return "viewCategory.jsp";
	}

	@PostMapping("/categories/{id}")
	public String addProductToCategory(@PathVariable("id") Long id, @ModelAttribute("category") Category category,
			@RequestParam("product") Long product, Model viewModel) {
		System.out.println(product);
		this.aService.addProductToCategory(id, product);
		return "redirect:/categories/" + id;
	}

	@GetMapping("/categories/new")
	public String newCategory(@ModelAttribute("category") Category category, Model viewModel) {
		return "newCategory.jsp";
	}

	@PostMapping("/categories/new")
	public String addCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if (result.hasErrors()) {
			return "newCategory.jsp";
		}
		this.aService.createCategory(category);
		return "redirect:/landing";
	}
}
