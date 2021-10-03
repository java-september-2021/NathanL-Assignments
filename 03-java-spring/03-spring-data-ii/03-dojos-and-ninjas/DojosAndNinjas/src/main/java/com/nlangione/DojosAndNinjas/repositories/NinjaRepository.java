package com.nlangione.DojosAndNinjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nlangione.DojosAndNinjas.models.Ninja;



@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long>{
	// this method retrieves all the books from the database
    List<Ninja> findAll();
}
