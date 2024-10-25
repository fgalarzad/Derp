package com.cibertec.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Empleado")
public class Empleado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idempleado;
	private String nombre, cargo;
	
	@Override
	public String toString() 
	{
		return "Empleado [idempleado="+idempleado+", nombres="+nombre+", cargo="+cargo+"]";
	}

}
