package com.devsuperior.dsvendas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsvendas.dto.SaleDTO;
import com.devsuperior.dsvendas.dto.SaleSuccessDTO;
import com.devsuperior.dsvendas.dto.SaleSumDTO;
import com.devsuperior.dsvendas.entities.Sale;
import com.devsuperior.dsvendas.repositories.SaleRepository;
import com.devsuperior.dsvendas.repositories.SellerRepository;

@Service // registra a camada como um componente
public class SaleService {

	@Autowired

	// Declarar uma dependencia com o repository
	private SaleRepository repository;

	@Autowired
	// Antes de retornar todos os salevou buscar todos os vendedores
	private SellerRepository sellerRepository;

	@Transactional(readOnly = true) // toda comunicação seja resolvida aqui e seja somente leitura
	// buscar uma lista de todos
	public Page<SaleDTO> findAll(Pageable pageable) {
		sellerRepository.findAll(); // vou trazer todos os vendedores para a memoria
		Page<Sale> result = repository.findAll(pageable);
		return result.map(x -> new SaleDTO(x));
	}
	// O serviço irá chamar o repository que é a camada de acesso aos dados
	// Page é a extrutura da pagina

	@Transactional(readOnly = true)
	public List<SaleSumDTO> amountGroupedBySeller() {
		return repository.amountGroupedBySeller();
	}

	@Transactional(readOnly = true)
	public List<SaleSuccessDTO> successGroupedBySeller() {
		return repository.sucessGroupedBySeller();
	}

}

//CAMADA DE SERVIÇOS 