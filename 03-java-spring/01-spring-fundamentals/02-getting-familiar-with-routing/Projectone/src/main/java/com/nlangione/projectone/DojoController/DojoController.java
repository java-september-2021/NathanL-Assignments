package com.nlangione.projectone.DojoController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DojoController {
	@RequestMapping("/dojo")
	public String dojo() {
		System.out.println("The dojo is awesome!");
		return "The dojo is awesome!";
	}
	
	@RequestMapping("/dojo/{location}")
	public String dojoCenter(@PathVariable("location") String location) {
		switch(location) {
		case "burbank":
			System.out.println("Burbank Dojo is located in Southern California");
			return "Burbank Dojo is located in Southern California";
		case "san-jose":
			System.out.println("SJ dojo is the headquarters");
			return "SJ dojo is the headquarters";
		default:
			System.out.printf("%s is pretty sweet!", location);
			return String.format("%s is pretty sweet!", location);
		}
	}
}
