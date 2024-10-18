package com.example.demo.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("titulo", mav);
		mav.addObject("nombreAsignatura", mav);
		
		return mav;
	}
}
