package com.cibertec.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="productos")
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idproducto;
	private String descripcion,costounitario,stock,receta, costoporblister;
	
	@Override
	public String toString() 
	{
		return "Producto [idproducto="+idproducto+", descripcion="+descripcion+", costounitario="+costounitario+", costoporblister="
	+costoporblister+", stock="+stock+", receta="+receta+"]";
	} 
	
	public int getIdproducto() {
		return idproducto;
	}

	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}

	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getCostounitario() {
		return costounitario;
	}
	public void setCostounitario(String costounitario) {
		this.costounitario = costounitario;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	public String getReceta() {
		return receta;
	}
	public void setReceta(String receta) {
		this.receta = receta;
	}
	public String getCostoporblister() {
		return costoporblister;
	}
	public void setCostoporblister(String costoporblister) {
		this.costoporblister = costoporblister;
	}
	
	
	
	
}
