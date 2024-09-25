package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Demo2Controller {

	@Value("${aplicacion.nombre}")
	private String nombreAplicacion;

	// Definimos el objeto de log
	private static final Logger loggerController = LoggerFactory.getLogger(Demo2Controller.class);

	@GetMapping(value = "/helloModel")
	public String hello(Model model) {
		model.addAttribute("título", nombreAplicacion);
		model.addAttribute("mensaje", "hola desde Thymeleaf con Model");

		loggerController.info("Mostramos el mensaje de hola con Model");

		// Retornamos la vista que mostrará los valores de los atributos
		return "helloView";
	}

	@GetMapping(value = "/helloModelMap")
	public String hello(ModelMap map) {
		map.addAttribute("titulo", "ModelMap");
		map.addAttribute("mensaje", "hola desde Thymeleaf con ModelMap");

		loggerController.info("Mostramos el mensaje de hola con ModelMap");

		// Retornamos la vista que mostrará los valores de los atributos
		return "helloView";
	}
	
	@GetMapping(value = "/helloModelAndView")
	//el metodo se puede llamar igual que los anteriores
	public ModelAndView helloMAV() {
		ModelAndView mav  = new ModelAndView();
		mav.addObject("titulo", nombreAplicacion);
		mav.addObject("mensaje", "hola desde Thymeleaf con ModelAndView");

		loggerController.info("Mostramos el mensaje de hola con ModelAndView");

		mav.setViewName("helloView");
		
		// Retornamos la vista que mostrará los valores de los atributos
		return mav;
	}

}
