package com.nlangione.DojosAndNinjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlangione.DojosAndNinjas.models.Dojo;
import com.nlangione.DojosAndNinjas.models.Ninja;
import com.nlangione.DojosAndNinjas.repositories.DojoRepository;
import com.nlangione.DojosAndNinjas.repositories.NinjaRepository;



@Service
public class DojoService {
	@Autowired
	private DojoRepository dojoRepo;
	
	@Autowired
	private NinjaRepository ninjaRepo;
	
	// Get Every Single Ninja From Database And Return In ArrayList
	public List<Ninja> getAllNinjas(){
		return this.ninjaRepo.findAll();
	}
	
	// Get One Ninja
	public Ninja getOneNinja(Long id) {
		return this.ninjaRepo.findById(id).orElse(null);		
	}
	
	// Create Ninja
	public Ninja createNinja(Ninja ninja) {
		return this.ninjaRepo.save(ninja);
	}
	
	
	// Get Every Single Dojo From Database And Return In ArrayList
	public List<Dojo> getAllDojos(){
		return this.dojoRepo.findAll();
	}
	
	// Get One Dojo
	public Dojo getOneDojo(Long id) {
		return this.dojoRepo.findById(id).orElse(null);		
	}
	
	// Create Dojo
	public Dojo createDojo(Dojo dojo) {
		return this.dojoRepo.save(dojo);
	}
}