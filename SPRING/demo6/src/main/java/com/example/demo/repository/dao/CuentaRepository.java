package com.example.demo.repository.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.entity.Cuenta;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
	
	@Query(value= "SELECT * FROM cuentas WHERE idcliente = ?1", nativeQuery=true)
	public List<Cuenta> findAllByCliente(Long idCliente);

	/*
	 * @Query(value = "SELECT * FROM cuentas WHERE idcliente = :idc", nativeQuery = true)
	 * public List<Cuenta> findAllByCliente(@Param("idc") Long idCliente);
	 */
}
