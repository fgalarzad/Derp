package com.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cibertec.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto,Integer>{

}
