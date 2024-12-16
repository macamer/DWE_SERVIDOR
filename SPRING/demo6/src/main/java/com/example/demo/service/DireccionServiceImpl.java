package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.ClienteDTO;
import com.example.demo.model.dto.DireccionDTO;
import com.example.demo.repository.dao.ClienteRepository;
import com.example.demo.repository.dao.DireccionRepository;
import com.example.demo.repository.entity.Cliente;
import com.example.demo.repository.entity.Direccion;

@Service
public class DireccionServiceImpl implements DireccionService {
	private static final Logger log = LoggerFactory.getLogger(DireccionServiceImpl.class);
	
	@Autowired
	private DireccionRepository direccionRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public List<DireccionDTO> findAllByCliente(ClienteDTO clienteDTO) {
		log.info("DireccionServiceImpl - findAllByCliente: Lista de todas las direcciones del cliente: "
				+ clienteDTO.getId());
		
		// Obtenemos la lista de direcciones del cliente 
		List<Direccion> lista = (List<Direccion>) direccionRepository.findAllByCliente(clienteDTO.getId());
		List<DireccionDTO> listaDireccionesDTO = new ArrayList<DireccionDTO>();
		for (int i=0; i<lista.size(); i++) {
			listaDireccionesDTO.add(DireccionDTO.convertToDTO(lista.get(i), clienteDTO));
		}
		
		return listaDireccionesDTO;
	}

	@Override
	public void save(DireccionDTO direccionDTO) {
		log.info("DireccionServiceImpl - save: Guarda la direccion del cliente: "
				+ direccionDTO.getListaClientesDTO().get(0).getId());
		
		//Solo hay un clienteDTO en la direccion
		Optional<Cliente> cliente = clienteRepository.findById(direccionDTO.getListaClientesDTO().get(0).getId());
		
		if(cliente.isPresent()) {
			//creamos las relaciones en las entidades
			Direccion direccion = DireccionDTO.convertToEntity(direccionDTO, cliente.get());
			cliente.get().getListaDirecciones().add(direccion);
			//Almacenamos la direccion, y por la relacion que tiene, almacenará la relación N a N
			direccionRepository.save(direccion);
		}
		
	}

}
