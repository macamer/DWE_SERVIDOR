package com.example.demo.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.dto.ClienteDTO;
import com.example.demo.model.dto.CuentaDTO;
import com.example.demo.service.ClienteService;
import com.example.demo.service.CuentaService;

@Controller
public class CuentaController {

	private static final Logger log = LoggerFactory.getLogger(CuentaController.class);
	
	@Autowired
	private CuentaService cuentaService;
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/clientes/{idCliente}/cuentas")
	public ModelAndView findAllByCliente(@PathVariable Long idCliente) {
		log.info("CuentaController - findAllByCliente: Mostramos todas las cuentas del cliente:" + idCliente);
		
		//obtenemos el cliente
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setId(idCliente);
		clienteDTO = clienteService.findById(clienteDTO);
		
		//obtenemos la lista de cuentas
		List<CuentaDTO> listaCuentasDTO = cuentaService.findAllByCliente(clienteDTO);
		log.warn("CuentaController - numero cuentas: "+ listaCuentasDTO.size());
		
		ModelAndView mav = new ModelAndView("cuentas");
		mav.addObject("clienteDTO", clienteDTO);
		mav.addObject("listaCuentasDTO", listaCuentasDTO);
		
		return mav;
	}
	
}
