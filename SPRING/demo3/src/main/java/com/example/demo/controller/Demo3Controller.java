package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entities.Alumno;

@Controller
public class Demo3Controller {
	
	private static final Logger loggerController = LoggerFactory.getLogger(Demo3Controller.class);
	
	@GetMapping("/")
	public String index(Model model) {
		loggerController.info("Devuelve la página de index");
		model.addAttribute("objetoAlumno", new Alumno());
		return "index";
	}
	
	@PostMapping("/altaAlumno")
	//public String altaAlumnoSubmit(@ModelAttribute Alumno alumno, @Model model) --> tanto alumno como model pueden aportar la información, se puede quitar uno de los dos
	public String altaAlumnoSubmit(@ModelAttribute Alumno alumno) {
		loggerController.info("alumno.toString()");
		//model.addAttribute("alumnoOk", alumno); --> sin el model ya no hace falta
		return "helloAlumno";
	}
}
