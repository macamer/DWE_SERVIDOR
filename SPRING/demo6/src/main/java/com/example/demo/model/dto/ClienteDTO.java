package com.example.demo.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.ToString;

import com.example.demo.repository.entity.Cliente;
import com.example.demo.repository.entity.ClienteDireccion;
import com.example.demo.repository.entity.Cuenta;
import com.example.demo.repository.entity.Direccion;
import com.example.demo.repository.entity.Recomendacion;

//serialize the class, so it can be sent to web
@Data
public class ClienteDTO implements Serializable {

	// create a id for the class
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nif;
	private String nombre;
	private String apellidos;
	private String claveSeguridad;
	private String email;
	private RecomendacionDTO recomendacionDTO; // if we have an entity we have to transform to DTO class too

	@ToString.Exclude
	private List<CuentaDTO> listaCuentasDTO;
	@ToString.Exclude
	private List<DireccionDTO> listaDireccionesDTO;

	// convert a entity to a DTO
	public static ClienteDTO convertToDTO(Cliente cliente) {
		// create new Cliente and assign basic data
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setId(cliente.getId());
		clienteDTO.setNif(cliente.getNif());
		clienteDTO.setNombre(cliente.getNombre());
		clienteDTO.setApellidos(cliente.getApellidos());
		clienteDTO.setClaveSeguridad(cliente.getClaveSeguridad());
		clienteDTO.setEmail(cliente.getEmail());

		RecomendacionDTO rec = RecomendacionDTO.convertToDTO(cliente.getRecomendacion(), clienteDTO); // convert to DTO
		clienteDTO.setRecomendacionDTO(rec);

		// Cargamos la lista de cuentas, que como es un Hashset hemos de convertir a ArrayList
		List<Cuenta> listaCuentas = new ArrayList<Cuenta>(cliente.getListaCuentas());
		for (int i = 0; i < cliente.getListaCuentas().size(); i++) {
			//CuentaDTO cuentadto = CuentaDTO.convertToDTO(cliente.getListaCuentas().get(i), clienteDTO);
			CuentaDTO cuentadto = CuentaDTO.convertToDTO(listaCuentas.get(i), clienteDTO);
			clienteDTO.getListaCuentasDTO().add(cuentadto);
		}
		
		// Cargamos la lista de direcciones, que como es un Hashset hemos de convertir a ArrayList
		/*
		List<Direccion> listaDirecciones = new ArrayList<Direccion>(cliente.getListaDirecciones());
		for(int i=0; i<cliente.getListaDirecciones().size(); i++) {
			//DireccionDTO direcciondto = DireccionDTO.convertToDTO(cliente.getListaDirecciones().get(i), clienteDTO);
			DireccionDTO direcciondto = DireccionDTO.convertToDTO(listaDirecciones.get(i), clienteDTO);
			clienteDTO.getListaDireccionesDTO().add(direcciondto);
		}*/
		
		List<ClienteDireccion> listaClientesDirecciones = new ArrayList<ClienteDireccion>(cliente.getListaClientesDirecciones());
		for(int i=0; i<cliente.getListaClientesDirecciones().size(); i++) {
			// Como solo nos interesa la direccion la lista que tenemos sera la lista de direccionesDTO
			DireccionDTO direcciondto = DireccionDTO.convertToDTO(listaClientesDirecciones.get(i).getDireccion(), clienteDTO);
			clienteDTO.getListaDireccionesDTO().add(direcciondto);
		}

		return clienteDTO;
	}

	// convert DTO to a entity
	public static Cliente convertToEntity(ClienteDTO clienteDTO) {
		Cliente cliente = new Cliente();
		cliente.setId(clienteDTO.getId());
		cliente.setNif(clienteDTO.getNif());
		cliente.setNombre(clienteDTO.getNombre());
		cliente.setApellidos(clienteDTO.getApellidos());
		cliente.setClaveSeguridad(clienteDTO.getClaveSeguridad());
		cliente.setEmail(clienteDTO.getEmail());

		Recomendacion rec = RecomendacionDTO.convertToEntity(clienteDTO.getRecomendacionDTO(), cliente);
		cliente.setRecomendacion(rec);

		// Cargamos la lista de cuentas
		for (int i = 0; i < clienteDTO.getListaCuentasDTO().size(); i++) {
			Cuenta cuenta = CuentaDTO.convertToEntity(clienteDTO.getListaCuentasDTO().get(i));
			cliente.getListaCuentas().add(cuenta);
		}
		
		// Cargamos la lista de direcciones
		for(int i=0; i<clienteDTO.getListaDireccionesDTO().size(); i++) {
			Direccion direccion = DireccionDTO.convertToEntity(clienteDTO.getListaDireccionesDTO().get(i), cliente);
			ClienteDireccion cd = new ClienteDireccion();
			cd.setCliente(cliente);
			cd.setDireccion(direccion);
			cliente.getListaClientesDirecciones().add(cd);
		}

		return cliente;
	}

	// empty constructor
	public ClienteDTO() {
		super();
		this.recomendacionDTO = new RecomendacionDTO();
		this.listaCuentasDTO= new ArrayList<CuentaDTO>();
		this.listaDireccionesDTO = new ArrayList<DireccionDTO>();
	}

}
