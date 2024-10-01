package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class IndexController {

	@GetMapping(value= {"/","/index"})
	public String idx(HttpServletResponse response, 
			@CookieValue(name="Cookie1", required=false) String lecturaCookie,
			Model objModel) {
		
		//si la cookie no existe, la crea
		if (lecturaCookie == null) {
			Cookie objCookie = new Cookie("Cookie1", "Bienvenido");
			//tiempo de vigencia --> en este caso 24 horas
			objCookie.setMaxAge(24 * 60 * 60);
			//va a añadir la cookie a la respuesta al cliente
			response.addCookie(objCookie);
			//pasar mensaje en model
			objModel.addAttribute("Acceso", "Es la primera vez que accedes.");
		} else {
			objModel.addAttribute("Acceso", "Bienvenido de nuevo: "+ lecturaCookie);
		}

		
		return "index";
	}
}
