package com.example.demo.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.dto.ClienteDTO;
import com.example.demo.model.dto.ClienteDireccionDTO;
import com.example.demo.model.dto.DireccionDTO;
import com.example.demo.service.ClienteService;
import com.example.demo.service.DireccionService;

@Controller
public class DireccionController {
	private static final Logger log = LoggerFactory.getLogger(DireccionController.class);
	
	@Autowired
	private DireccionService direccionService;
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/clientes/{idCliente}/direcciones")
	public ModelAndView findAllByCliente(@PathVariable Long idCliente) {
		log.info("DireccionController - findAllByCliente: Listamos las direcciones del cliente: " + idCliente);
		
		//Obtenemos el cliente para luego poner sus datos en la pantalla
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setId(idCliente);
		clienteDTO = clienteService.findById(clienteDTO);
		
		//Obtenemos la lista de direccioens del cliente
		List<ClienteDireccionDTO> listaClientesDireccionesDTO = direccionService.findAllByCliente(clienteDTO);
		
		//Pasamos los datos al modelo
		ModelAndView mav = new ModelAndView("direcciones");
		mav.addObject("listaClientesDireccionesDTO", listaClientesDireccionesDTO);
		mav.addObject("clienteDTO", clienteDTO);
		return mav;
	}
	
	@GetMapping("/clientes/{idCliente}/direcciones/add")
	public ModelAndView add(@PathVariable Long idCliente) {
		log.info("DireccionController - add: Anyadimos una nueva direccion al cliente: "
				+ idCliente);
		
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setId(idCliente);
		clienteDTO = clienteService.findById(clienteDTO);
		
		ModelAndView mav = new ModelAndView("direccionesform");
		mav.addObject("direccionDTO", new DireccionDTO());
		mav.addObject("clienteDTO", clienteDTO);
		return mav;
	}
	
	@PostMapping("/clientes/{idCliente}/direcciones/save")
	public ModelAndView save(@PathVariable Long idCliente, @ModelAttribute("direccionDTO") DireccionDTO direccionDTO) {
		log.info("DireccionController - save: Almacenamos la direccion " +
				direccionDTO.toString());
		
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setId(idCliente);
		clienteDTO = clienteService.findById(clienteDTO);
		
		//Añadimos al cliente la direccion. Puede haber varias direcciones ya en el clienteDTO
		//clienteDTO.getListaDireccionesDTO().add(direccionDTO);
		direccionDTO.getListaClientesDTO().add(clienteDTO);
		direccionService.save(direccionDTO);
		
		ModelAndView mav = new ModelAndView("redirect:/clientes/{idCliente}/direcciones");
		return mav;
	}
}
