package com.example.demo.model.dto;

import java.io.Serializable;

import com.example.demo.repository.entity.Recomendacion;

import lombok.ToString;

public class RecomendacionDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String observaciones;
	@ToString.Exclude //don't show Cliente into toString()
	private ClienteDTO clienteDTO;
	
	public static RecomendacionDTO convertToDTO(Recomendacion recomendacion) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Recomendacion convertToEntity(RecomendacionDTO recomendacionDTO) {
		// TODO Auto-generated method stub
		return null;
	}
}
