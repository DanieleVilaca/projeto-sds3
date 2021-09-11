package com.devsuperior.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsvendas.entities.Seller;

public interface SellerRepository extends JpaRepository<Seller,Long>{

}


//acoes de inserção, delete,update virão através desta comunicação 

//CAMADA DE ACESSO AOS DADOS