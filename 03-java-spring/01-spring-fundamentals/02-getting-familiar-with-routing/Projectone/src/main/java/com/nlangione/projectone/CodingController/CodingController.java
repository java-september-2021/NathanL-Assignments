package com.nlangione.projectone.CodingController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CodingController {
	
	@RequestMapping("/coding")
	public String index() {
		System.out.println("Hello coding dojo");
		return "Hello coding dojo!";
	}
	
	@RequestMapping("/coding/python")
	public String python() {
		System.out.println("Python/Django was awesome!");
		return "Python/Django was awesome!";
	}
	
	@RequestMapping("/coding/java")
	public String java() {
		System.out.println("Java/Spring is better!!");
		return "Java/Spring is better!!";
	}
}
