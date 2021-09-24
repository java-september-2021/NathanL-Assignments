package com.nlangione.Languages.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nlangione.Languages.models.Language;
import com.nlangione.Languages.services.LanguageService;

@Controller
public class LanguagesController {
    private final LanguageService languageService;
    
	public LanguagesController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
    @RequestMapping("/languages")
    public String index(Model model) {
    	List<Language> languages = languageService.getAllLanguages();
    	model.addAttribute("languages", languages);
        return "index.jsp";
    }
   
  
}


	
		
