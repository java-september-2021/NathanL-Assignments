package com.nlangione.albums.controllers;

import java.util.Date;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nlangione.albums.models.Album;
import com.nlangione.albums.models.User;
import com.nlangione.albums.services.AlbumService;
import com.nlangione.albums.services.UserService;
import com.nlangione.albums.validators.UserValidator;

@Controller
public class HomeController {
	@Autowired
	private AlbumService aService;
	@Autowired
	private UserService uService;
	@Autowired
	private UserValidator validator;
	
	
	//redirect root to display landing/registration page
	@GetMapping("/")
	public String landing(@ModelAttribute("user") User user) {
		return "landing.jsp";
	}	
	
	//submit registration request
	@PostMapping("/registerUser")
	public String register(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		validator.validate(user, result);
		if(result.hasErrors()) {
			return "landing.jsp";
		}
		User newUser = this.uService.registerUser(user);
		session.setAttribute("user__id", newUser.getId());
		return "redirect:/dashboard";
	}
	
	//submit login request
	@PostMapping("/login")
	public String login(HttpSession session, @RequestParam("lemail") String email, @RequestParam("lpassword") String password, RedirectAttributes redirectAttr) {
		if(!this.uService.authenticateUser(email, password)) {
			redirectAttr.addFlashAttribute("loginError", "Invalid Credentials");
			return "redirect:/";
			}
		User userToBeLoggedIn = this.uService.getUserByEmail(email);
		session.setAttribute("user__id", userToBeLoggedIn.getId());
		return "redirect:/dashboard";
	}
	
	//logout user
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	
	//display dashboard
	@GetMapping("/dashboard")
	public String index(Model viewModel, HttpSession session) {
		if(session.getAttribute("user__id") == null) {
			return "redirect:/";
		}
		viewModel.addAttribute("user", this.uService.getOneUser((Long)session.getAttribute("user__id")));
		viewModel.addAttribute("allAlbums", this.aService.getAllAlbums());
		return "index.jsp";
	}	
	
	//show user profile
	@GetMapping("/profile/{id}")
	public String userProfile(@PathVariable("id") Long id, Model viewModel) {
		viewModel.addAttribute("user", this.uService.getOneUser(id));
		return "profile.jsp";
	}
	
	//show new page
	@GetMapping("/new")
	public String add(@ModelAttribute("album") Album album, HttpSession session, Model viewModel) {
		viewModel.addAttribute("userID", (Long)session.getAttribute("user__id"));
		return "add.jsp";
	}
	
	//submit new album request with jstl form
	@PostMapping("/new")
	public String addRecord(@Valid @ModelAttribute("album") Album album, BindingResult result,HttpSession session) {
		User user = this.uService.getOneUser((Long)session.getAttribute("user__id"));
		album.setOwner(user);
		if(result.hasErrors()) {
			return "add.jsp";
		}
		this.aService.createAlbum(album);
		return "redirect:/dashboard";
	}
	
	//submit new album request with html form instead of jstl forms
	@PostMapping("/htmladd")
	public String htmlAdd(@RequestParam("albumName") String album, @RequestParam("bandName") String band, @RequestParam("year") Integer year, @RequestParam("yearBought") Date yearBought) {
		Album albumToSave = new Album(album, band, year, yearBought);
		this.aService.createAlbum(albumToSave);
		return "redirect:/dashboard";
	}
	

	//show edit page
	@GetMapping("/edit/{id}")
	public String editRecord(@PathVariable("id") Long id, @ModelAttribute("album") Album album, Model viewModel) {
		viewModel.addAttribute("album", this.aService.getOneAlbum(id));
		return "edit.jsp";
	}
	
	//submit edit request
	@PostMapping("/edit/{id}")
	public String edit(@Valid @ModelAttribute("album") Album album, BindingResult result, @PathVariable("id") Long id, Model viewModel) {
		if(result.hasErrors()) {
			viewModel.addAttribute("album", this.aService.getOneAlbum(id));
			return "edit.jsp";
		}
		this.aService.editAlbum(album);
		return "redirect:/dashboard";
	}
	
	//delete an album
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		this.aService.deleteAlbum(id);
		return "redirect:/dashboard";
	}
	
	//like an album
	@GetMapping("/like/{id}")
	public String like(@PathVariable("id") Long id, HttpSession session) {
		User userToLikeAlbum = this.uService.getOneUser((Long)session.getAttribute("user__id"));
		Album albumToLike = this.aService.getOneAlbum(id);
		// add them together
		this.aService.likeAlbum(userToLikeAlbum, albumToLike);
		return "redirect:/dashboard";
	}
	
	//unlike an album
	@GetMapping("/unlike/{id}")
	public String unlike(@PathVariable("id") Long id, HttpSession session) {
		User userTounLikeAlbum = this.uService.getOneUser((Long)session.getAttribute("user__id"));
		Album albumTounLike = this.aService.getOneAlbum(id);
		// add them together
		this.aService.unlikeAlbum(userTounLikeAlbum, albumTounLike);
		return "redirect:/dashboard";
	}
		
	
	//display album details
	@GetMapping("/details/{id}")
	public String show(@PathVariable("id") Long id, Model viewModel, HttpSession session) {
		viewModel.addAttribute("albumDetails", this.aService.getOneAlbum(id));
		viewModel.addAttribute("loggedInUser", (Long)session.getAttribute("user__id"));
		return "show.jsp";
	}
}