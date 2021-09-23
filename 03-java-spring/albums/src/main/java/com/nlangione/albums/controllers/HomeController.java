package com.nlangione.albums.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nlangione.albums.models.Album;
import com.nlangione.albums.services.AlbumService;

@RestController
public class HomeController {
	@Autowired
	private AlbumService aService;
	
	@GetMapping("/")
	public List<Album> index(){
		return this.aService.getAllAlbums();
	}
	
	@GetMapping("/{id}")
	public Album getOne(@PathVariable("id") Long id) {
		return this.aService.getOneAlbum(id);
	}
	
	@PostMapping("/create")
	public Album create(Album album) {
		return this.aService.createAlbum(album);
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		return this.aService.deleteAlbum(id);
	}
}