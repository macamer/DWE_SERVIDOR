package com.example.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.ClienteDTO;
import com.example.demo.repository.entity.Cliente;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	private static final Logger log = LoggerFactory.getLogger(ClienteServiceImpl.class);
	
	@Autowired
	private ClienteRepository clienteRepository;
	

	@Override
	public List<ClienteDTO> findAll() {
		
		log.info("ClienteServiceImpl - findAll: Lista de todos los clientes");
		
		List<ClienteDTO> listaClientesDTO = null;
		//repository is missing
		List<Cliente> listaClientes = clienteRepository.findAll();
		for(int i=0; i<listaClientes.size(); i++) {
			Cliente cliente = listaClientes.get(i);
			ClienteDTO clienteDTO = ClienteDTO.convertToDTO(cliente);
			listaClientesDTO.add(clienteDTO);
		}
		
		return listaClientesDTO;		
	}

	@Override
	public ClienteDTO findById(ClienteDTO clienteDTO) {
		log.info("ClienteServiceImpl - findById: Buscar Cliente por ID: " + clienteDTO.getId());
		
		Cliente cliente = new Cliente();
		cliente.setId(clienteDTO.getId());
		
		cliente = clienteRepository.findById(cliente);
		
		if(cliente!=null) {
			clienteDTO = ClienteDTO.convertToDTO(cliente);
			return clienteDTO;
		} else {
			return null;
		}
	}

	@Override
	public void save(ClienteDTO clienteDTO) {
		log.info("ClienteServiceImpl - save: salvamos el cliente: " + clienteDTO.toString());
		
		Cliente cliente = clienteDTO.contertToEntity(clienteDTO);
		//repository is missing
		clienteRepository.save(cliente);		
	}

	@Override
	public void delete(ClienteDTO clienteDTO) {
		log.info("ClienteServiceImpl - delete: borramos el cliente: " + clienteDTO.getId());
		
		Cliente cliente = new Cliente();
		cliente.setId(clienteDTO.getId());
		//repository is missing
		clienteRepository.delete(cliente);	
		
	}

}