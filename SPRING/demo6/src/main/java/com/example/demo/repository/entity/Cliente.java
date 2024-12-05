package com.example.demo.repository.entity;

import java.util.Objects;

import lombok.Data;

@Data //is part of lambok, makes mapping easier 
public class Cliente {

	private Long id;
	private String nif;
	private String nombre;
	private String apellidos;
	private String claveSeguridad;
	private String email;
	private Recomendacion recomendacion;
	
	//we only want to check if the id is the same, so we override the method
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(id, other.id);
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
}
