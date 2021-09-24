package com.nlangione.Languages2.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nlangione.Languages2.models.Language;
import com.nlangione.Languages2.services.LanguageService;

@Controller
public class LanguageController {
	@Autowired
    private LanguageService aService;
    
	
    @GetMapping("/languages")
    public String index(@ModelAttribute("language") Language language, Model viewModel) {
    	viewModel.addAttribute("allLanguages", this.aService.getAllLanguages());
        return "index.jsp";
    }
	
	@PostMapping("/languages")
	public String addLanguage(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		if(result.hasErrors()) {
			return "index.jsp";
		}
		this.aService.createLanguage(language);
		return "redirect:/languages";
	}
	
	@GetMapping("/languages/{id}")
	public String viewLanguage(@PathVariable("id") Long id, @ModelAttribute("language") Language language, Model viewModel) {
		viewModel.addAttribute("language", this.aService.getOneLanguage(id));
		return "view.jsp";
	}
		

	@GetMapping("/languages/{id}/edit")
	public String editLanguage(@PathVariable("id") Long id, @ModelAttribute("language") Language language, Model viewModel) {
		viewModel.addAttribute("language", this.aService.getOneLanguage(id));
		return "edit.jsp";
	}
	
	@PostMapping("/languages/{id}/edit")
	public String updateLanguage(@Valid @ModelAttribute("language") Language language, BindingResult result, @PathVariable("id") Long id, Model viewModel) {
		if(result.hasErrors()) {
			viewModel.addAttribute("language", this.aService.getOneLanguage(id));
			return "edit.jsp";
		}
		this.aService.editLanguage(language);
		return "redirect:/languages";
	}
	
	 @RequestMapping(value="/languages/{id}", method=RequestMethod.DELETE)
	    public String destroy(@PathVariable("id") Long id) {
	        aService.deleteLanguage(id);
	        return "redirect:/languages";
	 }
	
}


