package com.nlangione.DojosAndNinjas2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.nlangione.DojosAndNinjas2.models.Dojo;
import com.nlangione.DojosAndNinjas2.models.Ninja;
import com.nlangione.DojosAndNinjas2.services.DojoService;

@Controller
public class DojoController {
	@Autowired
    private DojoService aService;
	
	
	
	@GetMapping("/dojos")
    public String index(@ModelAttribute("dojo") Dojo dojo, Model viewModel) {
    	viewModel.addAttribute("allDojos", this.aService.getAllDojos());
        return "index.jsp";
    }
	
	@GetMapping("/dojos/new")
    public String newDojo(@ModelAttribute("dojo") Dojo dojo){
    	return "newDojo.jsp";
    }
	
	
	
	@GetMapping("/dojos/{id}")
	public String viewDojo(@PathVariable("id") Long id, @ModelAttribute("dogo") Dojo dojo, Model viewModel) {
		viewModel.addAttribute("dojo", this.aService.getOneDojo(id));
		return "dojoView.jsp";
	}
	
	@GetMapping("/ninjas/new")
    public String newNinja(@ModelAttribute("ninja") Ninja ninja){
    	return "newNinja.jsp";
    }
	
	
}