package com.devsuperior.dsvendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsvendas.dto.SellerDTO;
import com.devsuperior.dsvendas.service.SellerService;

@RestController //essa classe vai ser um controlador 
@RequestMapping (value = "/sellers") //Indicar qual o caminho 
public class SellerController {
	
	@Autowired 
	//O controlador depende do serviço
	private SellerService service;

	//Chamar o Endpoint
	@GetMapping 
	public ResponseEntity <List<SellerDTO>> findAll() {
		List<SellerDTO> list = service.findAll();
		return ResponseEntity.ok(list);
	}
}
