package com.example.demo.repository.entity;

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
}
