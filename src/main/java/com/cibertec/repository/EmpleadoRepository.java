package com.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cibertec.model.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado,Integer> {

}
