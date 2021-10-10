package com.nlangione.albums.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nlangione.albums.models.Song;
import com.nlangione.albums.services.AlbumService;
import com.nlangione.albums.services.SongService;

@Controller
@RequestMapping("/song")
public class SongController {
	@Autowired 
	private SongService sService;
	@Autowired
	private AlbumService aService;
	
	
	// localhost:8080/song/new
	@GetMapping("/new")
	public String create(@ModelAttribute("song") Song song, Model viewModel) {
		viewModel.addAttribute("albums", this.aService.getAllAlbums());
		return "/songs/new.jsp";
	}
	
	@PostMapping("/newSong")
	public String addSong(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		Long idAlbum = song.getAlbumSongIsOn().getId();
		if(result.hasErrors()) {
			return "/songs/new.jsp";
		}
		this.sService.create(song);
		return "redirect:/details/" + idAlbum;
	}
}