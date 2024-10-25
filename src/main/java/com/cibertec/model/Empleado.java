package com.cibertec.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Empleados")
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

	public int getIdempleado() {
		return idempleado;
	}

	public void setIdempleado(int idempleado) {
		this.idempleado = idempleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	

}