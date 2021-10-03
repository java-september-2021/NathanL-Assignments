package com.nlangione.DojosAndNinjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.nlangione.DojosAndNinjas.models.Dojo;
import com.nlangione.DojosAndNinjas.models.Ninja;
import com.nlangione.DojosAndNinjas.services.DojoService;


@Controller
public class DojoController {
	@Autowired
    private DojoService aService;
	
	
	@GetMapping("")
	public String root() {
		return "redirect:/dojos";
	}
	@GetMapping("/dojos")
    public String index(@ModelAttribute("dojo") Dojo dojo, Model viewModel) {
    	viewModel.addAttribute("allDojos", this.aService.getAllDojos());
        return "index.jsp";
    }
	
	@GetMapping("/dojos/new")
    public String newDojo(@ModelAttribute("dojo") Dojo dojo){
    	return "newDojo.jsp";
    }
	
	@PostMapping("/dojos/new")
	public String addDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "newDojo.jsp";
		}
		this.aService.createDojo(dojo);
		return "redirect:/dojos";
	}
	
	@GetMapping("/dojos/{id}")
	public String viewDojo(@PathVariable("id") Long id, @ModelAttribute("dogo") Dojo dojo, Model viewModel) {
		viewModel.addAttribute("dojo", this.aService.getOneDojo(id));
		return "dojoView.jsp";
	}
	
	@GetMapping("/ninjas/new")
    public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model viewModel){
		viewModel.addAttribute("allDojos", this.aService.getAllDojos());
    	return "newNinja.jsp";
    }
	
	@PostMapping("/ninjas/new")
	public String addNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model viewModel){
		viewModel.addAttribute("allDojos", this.aService.getAllDojos());
		if(result.hasErrors()) {
			return "newNinja.jsp";
		}
		this.aService.createNinja(ninja);
		return "redirect:/dojos";
	}
}
