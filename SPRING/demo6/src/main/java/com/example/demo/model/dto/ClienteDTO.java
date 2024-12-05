package com.example.demo.model.dto;

import java.io.Serializable;
import lombok.Data;
import com.example.demo.repository.entity.Cliente;
import com.example.demo.repository.entity.Recomendacion;


//serialize the class, so it can be sent to web
@Data
public class ClienteDTO implements Serializable {
	
	//create a id for the class
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nif;
	private String nombre;
	private String apellidos;
	private String claveSeguridad;
	private String email;
	private RecomendacionDTO recomendacionDTO; //if we have an entity we have to transform to DTO class too
	
	//convert a entity to a DTO
	public static ClienteDTO convertToDTO(Cliente cliente) {
		//create new Cliente and assign basic data
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setId(cliente.getId());
		clienteDTO.setNif(cliente.getNif());
		clienteDTO.setNombre(cliente.getNombre());
		clienteDTO.setApellidos(cliente.getApellidos());
		clienteDTO.setClaveSeguridad(cliente.getClaveSeguridad());
		clienteDTO.setEmail(cliente.getEmail());
		
		RecomendacionDTO rec = RecomendacionDTO.convertToDTO(cliente.getRecomendacion(), clienteDTO); //convert to DTO
		clienteDTO.setRecomendacionDTO(rec);
		
		return clienteDTO;
	}
	
	//convert DTO to a entity
	public static Cliente contertToEntity(ClienteDTO clienteDTO) {
		Cliente cliente = new Cliente();
		cliente.setId(clienteDTO.getId());
		cliente.setNif(clienteDTO.getNif());
		cliente.setNombre(clienteDTO.getNombre());
		cliente.setApellidos(clienteDTO.getApellidos());
		cliente.setClaveSeguridad(clienteDTO.getClaveSeguridad());
		cliente.setEmail(clienteDTO.getEmail());
		
		Recomendacion rec = RecomendacionDTO.convertToEntity(clienteDTO.getRecomendacionDTO(), cliente);
		cliente.setRecomendacion(rec);
		
		return cliente;
	}

	//empty constructor
	public ClienteDTO() {
		super();
		this.recomendacionDTO = new RecomendacionDTO();
	}
	
	
}
