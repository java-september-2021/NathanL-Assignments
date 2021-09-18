package com.nlangione.DojoSurvey.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DojoSurveyController {

	@RequestMapping("/") 
	public String index(HttpSession session){
		return "index.jsp";
	}

	@RequestMapping(path="/data", method=RequestMethod.POST)
    public String data(HttpSession session,
    		@RequestParam(value="username") String username,
    		@RequestParam(value="dojo") String dojo, 
    		@RequestParam(value="language") String language,
    		@RequestParam(value="comment") String comment) {
		session.setAttribute("username", username);
		session.setAttribute("dojo", dojo);
		session.setAttribute("language", language);
		session.setAttribute("comment", comment);
		return "redirect:/result";
	}
	
	@RequestMapping("/result")
	public String counter(HttpSession session, Model model) {
		model.addAttribute("username", session.getAttribute("username"));
		model.addAttribute("dojo", session.getAttribute("dojo"));
		model.addAttribute("language", session.getAttribute("language"));
		model.addAttribute("comment", session.getAttribute("comment"));
		return "result.jsp";
	}
}

