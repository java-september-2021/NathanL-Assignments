package com.nlangione.albums.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlangione.albums.models.Album;
import com.nlangione.albums.repositories.AlbumRepository;

@Service
public class AlbumService {
	@Autowired
	private AlbumRepository aRepo;
	
	/*
	public AlbumService(AlbumRepository repository) {
		this.aRepo = repository;
		
	}
	*/
	//get all albums
	public List<Album> getAllAlbums(){
		return this.aRepo.findall();
	}
	
	//get one album
	public Album getOneAlbum(Long id) {
		return this.aRepo.findById(id).orElse(null);
	}
	
	//create an album
	public Album createAlbum(Album album) {
		return this.aRepo.save(album);
	}
	
	// update album 
	public Album editAlbum(Album album) {
		return this.aRepo.save(album);
	}
	
	//delete
	public String deleteAlbum(Long id) {
		this.aRepo.deleteById(id);
		return "Album has been deleted";
	}
	
}
