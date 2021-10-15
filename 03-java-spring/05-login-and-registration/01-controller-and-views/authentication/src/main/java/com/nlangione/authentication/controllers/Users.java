package com.nlangione.authentication.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nlangione.authentication.models.User;
import com.nlangione.authentication.services.UserService;

@Controller
public class Users {
	@Autowired
	private  UserService userService;
 
	public Users(UserService userService) {
		this.userService = userService;
	}
	 
	 @GetMapping("")
	 public String root() {
	     return "loginPage.jsp";
	 }
	 
	 @GetMapping("/login")
	 public String login() {
	     return "loginPage.jsp";
	 }
	 
	 @GetMapping("/registration")
	 public String registerForm(@ModelAttribute("user") User user, Model viewModel) {
	     return "registrationPage.jsp";
	 }
	 
	 @PostMapping("/registration")
	 public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		 if (result.hasErrors()) {
				return "registrationPage.jsp";
			}
		 User u = userService.registerUser(user);
		 session.setAttribute("userId", u.getId());
		 return "redirect:/home";
	 }
	 
	 @PostMapping("/login")
	 public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
	     // if the user is authenticated, save their user id in session
		 boolean isAuthenticated = userService.authenticateUser(email, password);
		 if (isAuthenticated) {
			 User u = userService.findByEmail(email);
			 session.setAttribute("userId", u.getId());
			 return "redirect:/home";
		 }
	     // else, add error messages and return the login page
		 model.addAttribute("error", "Invalid credentials. Please try again.");
		 return "loginPage.jsp";
	 }
	 
	 @GetMapping("/home")
	 public String home(HttpSession session, Model model) {
	     // get user from session, save them in the model and return the home page
		 Long userId = (Long) session.getAttribute("userId");
		 User u = userService.findUserById(userId);
		 model.addAttribute("user", u);
		 return "homePage.jsp";
	 }
	 
	 @GetMapping("/logout")
	 public String logout(HttpSession session) {
	     // invalidate session
		 session.invalidate();
	     // redirect to login page
		 return "redirect:/login";
	 }
}
