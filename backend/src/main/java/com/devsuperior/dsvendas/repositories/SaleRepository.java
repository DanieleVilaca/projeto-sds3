package com.devsuperior.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale,Long>{

}


//acoes de inserção, delete,update virão através desta comunicação 

//CAMADA DE ACESSO AOS DADOS