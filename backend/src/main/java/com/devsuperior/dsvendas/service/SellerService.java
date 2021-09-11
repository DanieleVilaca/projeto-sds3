package com.devsuperior.dsvendas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dsvendas.dto.SellerDTO;
import com.devsuperior.dsvendas.entities.Seller;
import com.devsuperior.dsvendas.repositories.SellerRepository;

@Service // registra a camada como um componente 
public class SellerService {
    
	@Autowired   
    
	//Declarar uma dependencia com o repository 
	private SellerRepository repository; 
	                   //buscar uma lista de todos
	public List<SellerDTO> findAll(){
		List<Seller> result = repository.findAll();
		return result.stream().map(x -> new SellerDTO(x)).collect(Collectors.toList()); //para cada x irei converter para o seller dto
	}
  //O serviço irá chamar o repository que é a camada de acesso aos dados
}


//CAMADA DE SERVIÇOS 