package com.nlangione.Languages.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nlangione.Languages.models.Language;
import com.nlangione.Languages.services.LanguageService;

@Controller
public class LanguageController {
	@Autowired
    private LanguageService aService;
    
	
    @RequestMapping("/languages")
    public String index(Model model) {
    	List<Language> languages = aService.getAllLanguages();
    	model.addAttribute("languages", languages);
        return "index.jsp";
    }
   
  
}