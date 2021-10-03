package com.nlangione.DojosAndNinjas2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlangione.DojosAndNinjas2.models.Dojo;
import com.nlangione.DojosAndNinjas2.models.Ninja;
import com.nlangione.DojosAndNinjas2.repositories.DojoRepository;
import com.nlangione.DojosAndNinjas2.repositories.NinjaRepository;

@Service
public class DojoService {
	@Autowired
	private DojoRepository dojoRepo;
	
	@Autowired
	private NinjaRepository ninjaRepo;
	
	// Get Every Single Ninja From Database And Return In ArrayList
	public List<Ninja> gtrAllNinjas(){
		return this.ninjaRepo.findAll();
	}
	
	// Get Every Single Dojo From Database And Return In ArrayList
	public List<Dojo> getAllDojos(){
		return this.dojoRepo.findAll();
	}
	
	// Get One Dojo
	public Dojo getOneDojo(Long id) {
		return this.dojoRepo.findById(id).orElse(null);		
	}
}