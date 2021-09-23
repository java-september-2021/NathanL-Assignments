package com.nlangione.TheCode.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class TheCodeController {
	@RequestMapping("/") 
	public String index(HttpSession session, @ModelAttribute("errors") String errors){
		System.out.println(errors);
		return "index.jsp";
	}
	
	@RequestMapping(value="/data", method=RequestMethod.POST)
    public String data(HttpSession session,
    		@RequestParam(value="userCode") String userCode,
    		RedirectAttributes redirectAttributes) {
		
		
		session.setAttribute("userCode", userCode);
		String check = (String) session.getAttribute("userCode");
		if(check.equals("bushido")) {
			return "redirect:/code";
		} else {
			redirectAttributes.addFlashAttribute("errors", "You must train harder!");
			return "redirect:/";
		}
	}

	@RequestMapping("/code")
	public String code(HttpSession session, RedirectAttributes redirectAttributes) {
		if(session.getAttribute("userCode") == null) {
			redirectAttributes.addFlashAttribute("errors", "You must fill out the form!");
			return "redirect:/";
		} else {
			
			return "code.jsp";
		}
	}
}