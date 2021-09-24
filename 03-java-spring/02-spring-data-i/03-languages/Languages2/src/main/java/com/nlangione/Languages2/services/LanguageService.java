package com.nlangione.Languages2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlangione.Languages2.models.Language;
import com.nlangione.Languages2.repositories.LanguageRepository;

@Service
public class LanguageService {
	@Autowired
	private LanguageRepository aRepo;
	
	// Get Every Single Language From Database And Return In ArrayList
	public List<Language> getAllLanguages(){
		return this.aRepo.findAll();
	}
	
	// Get One Language
	public Language getOneLanguage(Long id) {
		return this.aRepo.findById(id).orElse(null);		
	}
	
	// Create Language
	public Language createLanguage(Language language) {
		return this.aRepo.save(language);
	}
	
	// Update Language
	public Language editLanguage(Language language) {
		return this.aRepo.save(language);
	}
	
	// Delete Language
	public String deleteLanguage(Long id) {
		this.aRepo.deleteById(id);
		return "Language has been deleted";
	}
}
