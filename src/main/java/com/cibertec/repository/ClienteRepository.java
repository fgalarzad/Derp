package com.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cibertec.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente,Integer>{

}
