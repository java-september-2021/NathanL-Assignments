package com.nlangione.albums.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlangione.albums.models.Song;
import com.nlangione.albums.repositories.SongRepository;

@Service
public class SongService {
	@Autowired
	private SongRepository sRepo;
	
	public Song create(Song song) {
		return this.sRepo.save(song);
	}
}