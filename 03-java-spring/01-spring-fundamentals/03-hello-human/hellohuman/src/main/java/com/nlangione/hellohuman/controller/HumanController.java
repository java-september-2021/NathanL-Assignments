package com.nlangione.hellohuman.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HumanController {

@RequestMapping("/")
public String index(@RequestParam(value="q", required=false) String userName, Model model) {
	System.out.println(userName);
	if(userName == null) {
		return "Hello Human!";
	} else {
		return "hello " + userName;
	}
	
	
}
}
