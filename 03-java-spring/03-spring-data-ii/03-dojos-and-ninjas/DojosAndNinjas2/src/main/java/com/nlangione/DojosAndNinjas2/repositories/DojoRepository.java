package com.nlangione.DojosAndNinjas2.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nlangione.DojosAndNinjas2.models.Dojo;

@Repository
public interface DojoRepository extends CrudRepository<Dojo, Long>{
	// this method retrieves all the books from the database
    List<Dojo> findAll();
}