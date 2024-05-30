package com.training.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("getratingdataservice")
	public String getWelcomeMessage() {
		return "welcome to rating data service";
	}

}
