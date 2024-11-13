package com.example.demo.model.dto;

import java.io.Serializable;
import java.util.Objects;

import lombok.Data;

@Data
public class CuentaDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Long id;
	private String banco;
	private String sucursal;
	private String dc;
	private String numeroCuenta;
	private Double saldoActual;
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CuentaDTO other = (CuentaDTO) obj;
		return Objects.equals(id, other.id);
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	
}
