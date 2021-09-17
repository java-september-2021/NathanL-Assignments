package com.nlangione.projectone.DojoController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DojoController {
	@RequestMapping("/{dojo}")
	public String index(@PathVariable("dojo") String foo) {
		System.out.println("The dojo is awesome!");
		return "The dojo is awesome!";
	}
	
	@RequestMapping("/dojo/{burbank}")
	public String burbank(@PathVariable("burbank") String foo) {
		System.out.println("Burbank Dojo is located in Southern California");
		return "Burbank Dojo is located in Southern California";
	}
	
	@RequestMapping("/dojo/{part1}-{part2}")
	public String sj(@PathVariable("part1") String foo,@PathVariable("part2") String bar) {
	return "SJ dojo is the headquarters";
	}
}
