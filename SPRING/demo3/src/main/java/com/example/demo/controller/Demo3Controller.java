package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Demo3Controller {
	
	private static final Logger loggerController = LoggerFactory.getLogger(Demo3Controller.class)
	
	@GetMapping("/")
	public String index(Model model) {
		loggerController.info("Devuelve la página de index");
		model.addAttribute("objetoAlumno", new Alumno());
		return "index";
	}
	
	
}
