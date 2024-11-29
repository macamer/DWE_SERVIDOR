package com.example.demo.repository.entity;

import lombok.Data;

@Data
public class Cuenta {
	private Long id;
	private String banco;
	private String sucursal;
	private String dc;
	private String numeroCuenta;
	private Double saldoActual;
	
}
