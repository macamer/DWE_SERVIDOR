package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.dto.ClienteDTO;
import com.example.demo.model.dto.CuentaDTO;

@Service
public interface CuentaService {

	List<CuentaDTO> findAllByCliente(ClienteDTO clienteDTO);

}
