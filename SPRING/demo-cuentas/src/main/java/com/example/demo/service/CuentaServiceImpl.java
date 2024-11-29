package com.example.demo.service;

import java.util.List;

import com.example.demo.model.dto.ClienteDTO;
import com.example.demo.model.dto.CuentaDTO;
import com.example.demo.repository.entity.Cliente;

public class CuentaServiceImpl implements CuentaService {

	@Override
	public List<CuentaDTO> findAllByCliente(ClienteDTO clienteDTO) {

		Cliente cliente = new Cliente();
		cliente.setId(clienteDTO.getId());
		
		
		
		return null;
	}

}
