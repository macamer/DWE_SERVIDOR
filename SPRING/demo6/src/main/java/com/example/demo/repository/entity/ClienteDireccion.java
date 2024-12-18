package com.example.demo.repository.entity;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "clientesdirecciones")
public class ClienteDireccion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="idcliente")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name="iddireccion")
	private Direccion direccion;
	
	//Atributo que almacena la fecha de nacimiento
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fechaalta")
	private Date fechaAlta;

	//Generamos el equals() y el hashcode() seleccionando cliente y direccion, pero
	//modificamos lo que genera automaticamente añadiendole tanto a cliente como a direccion
	// el metodo getId(), ya que nos interesa comparar sus ids y obtener el hashCode a partir de ellos
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClienteDireccion other = (ClienteDireccion) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(direccion, other.direccion)
				&& Objects.equals(id, other.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(cliente, direccion, id);
	}
	
	
}
