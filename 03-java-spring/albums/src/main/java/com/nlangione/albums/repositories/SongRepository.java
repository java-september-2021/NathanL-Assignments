package com.nlangione.albums.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nlangione.albums.models.Song;

@Repository
public interface SongRepository extends CrudRepository<Song, Long>{

}