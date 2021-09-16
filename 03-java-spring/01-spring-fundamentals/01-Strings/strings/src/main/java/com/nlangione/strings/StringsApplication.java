package com.nlangione.strings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class StringsApplication {

	public static void main(String[] args) {
		SpringApplication.run(StringsApplication.class, args);
	}
	@RequestMapping("/")
	public String msg1() {
		return "hello client! how are you doing?";
	}
	@RequestMapping("/random")
	public String msg2() {
		return "spring boot is great! So easy to just respong with strings";
	}
}
