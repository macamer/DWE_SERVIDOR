package com.example.demo.service;

import java.util.List;

import com.example.demo.model.dto.ClienteDTO;
import com.example.demo.model.dto.ClienteDireccionDTO;
import com.example.demo.model.dto.DireccionDTO;

public interface DireccionService {

	//List<DireccionDTO> findAllByCliente(ClienteDTO clienteDTO);
	List<ClienteDireccionDTO> findAllByCliente(ClienteDTO clienteDTO);
	void save(DireccionDTO direccionDTO);

}
