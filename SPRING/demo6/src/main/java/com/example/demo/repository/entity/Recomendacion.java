package com.example.demo.repository.entity;

import lombok.Data;
import lombok.ToString;

@Data
public class Recomendacion {
	private Long id;
	private String observaciones;
	@ToString.Exclude //don't show Cliente into toString()
	private Cliente cliente;
}
