package com.nlangione.albums.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nlangione.albums.models.Album;



@Repository
public interface AlbumRepository  extends CrudRepository<Album,Long>{
	List<Album> findall(); // SELECT * FROM albums
}
