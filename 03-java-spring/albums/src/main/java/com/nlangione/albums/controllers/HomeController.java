package com.nlangione.albums.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nlangione.albums.models.Album;
import com.nlangione.albums.models.User;
import com.nlangione.albums.services.AlbumService;
import com.nlangione.albums.services.UserService;

@Controller
public class HomeController {
	@Autowired
	private AlbumService aService;
	@Autowired
	private UserService uService;
	
	@GetMapping("/")
	public String landing(@ModelAttribute) {
		viewModel.addAttribute("allUsers", this.uService.getAllUsers());
		return "landing.jsp";
	}	
	
	@PostMapping("/login")
	public String login(HttpSession session, @RequestParam("usersToLogin") Long userid) {
		session.setAttribute("user__id", userid);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/dashboard")
	public String index(Model viewModel, HttpSession session) {
		if(session.getAttribute("user__id") == null) {
			return "redirect:/";
		}
		viewModel.addAttribute("user", this.uService.getOneUser((Long)session.getAttribute("user__id")));
		viewModel.addAttribute("allAlbums", this.aService.getAllAlbums());
		return "index.jsp";
	}	
	
	@GetMapping("/like/{id}")
	public String like(@PathVariable("id") Long id, HttpSession session) {
		User userToLikeAlbum = this.uService.getOneUser((Long)session.getAttribute("user__id"));
		Album albumToLike = this.aService.getOneAlbum(id);
		// add them together
		this.aService.likeAlbum(userToLikeAlbum, albumToLike);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/unlike/{id}")
	public String unlike(@PathVariable("id") Long id, HttpSession session) {
		User userToLikeAlbum = this.uService.getOneUser((Long)session.getAttribute("user__id"));
		Album albumTounLike = this.aService.getOneAlbum(id);
		// add them together
		this.aService.unlikeAlbum(userToLikeAlbum, albumTounLike);
		return "redirect:/dashboard";
	}
	
	
	@GetMapping("/new")
	public String add(@ModelAttribute("album") Album album) {
		return "add.jsp";
	}
	
	@PostMapping("/new")
	public String addRecord(@Valid @ModelAttribute("album") Album album, BindingResult result) {
		if(result.hasErrors()) {
			return "add.jsp";
		}
		this.aService.createAlbum(album);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/edit/{id}")
	public String editRecord(@PathVariable("id") Long id, @ModelAttribute("album") Album album, Model viewModel) {
		viewModel.addAttribute("album", this.aService.getOneAlbum(id));
		return "edit.jsp";
	}
	
	@PostMapping("/edit/{id}")
	public String edit(@Valid @ModelAttribute("album") Album album, BindingResult result, @PathVariable("id") Long id, Model viewModel) {
		if(result.hasErrors()) {
			viewModel.addAttribute("album", this.aService.getOneAlbum(id));
			return "edit.jsp";
		}
		this.aService.editAlbum(album);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/details/{id}")
	public String show(@PathVariable("id") Long id, Model viewModel) {
		viewModel.addAttribute("albumDetails", this.aService.getOneAlbum(id));
		return "show.jsp";
	}
	
	@PostMapping("/htmladd")
	public String htmlAdd(@RequestParam("albumName") String album, @RequestParam("bandName") String band, @RequestParam("year") Integer year) {
		Album albumToSave = new Album(album, band, year);
		this.aService.createAlbum(albumToSave);
		return "redirect:/dashboard";
	}
	

}