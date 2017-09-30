package com.stfo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stfo.services.DropsService;

@RestController
@RequestMapping("/api")
public class MainController {

	@Autowired
	private DropsService dropsService;
	
	/*@GetMapping("/")
	public void test () {
		dropsService.test();
	}*/
}
