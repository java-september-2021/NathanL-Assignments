package com.nlangione.dojoOverflow.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nlangione.dojoOverflow.models.Tag;

@Repository
public interface TagRepository extends CrudRepository <Tag, Long> {
	public List <Tag> findAll();
    public Optional <Tag> findBySubject(String subject);
}
