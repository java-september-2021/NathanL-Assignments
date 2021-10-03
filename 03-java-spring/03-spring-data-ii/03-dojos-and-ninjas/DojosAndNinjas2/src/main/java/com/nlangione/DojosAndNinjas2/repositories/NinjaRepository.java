package com.nlangione.DojosAndNinjas2.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nlangione.DojosAndNinjas2.models.Ninja;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long>{
	// this method retrieves all the books from the database
    List<Ninja> findAll();
}