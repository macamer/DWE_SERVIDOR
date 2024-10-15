package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MiPrimerControlador {

	
	@GetMapping("/holamodel")
	public String holaModel(Model modelo) {
		modelo.addAttribute("titulo", "Mi primera aplicación");
		return "helloView";
	}
	
	@GetMapping("holamac")
	public ModelAndView holaMav
}
