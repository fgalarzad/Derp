package com.cibertec.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Entierros")
public class Entierro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int identierro;
	private String nombrecliente,fallecido,relacion,costo,cajon,fechadedefuncion,fecha;
	
	@OneToMany(mappedBy = "entierro", cascade = CascadeType.ALL)
    private List<Empleado> empleados;
	@Override
	public String toString() 
	{
		return "Producto [identierro="+identierro+", fallecido="+fallecido+", fechadedefuncion="+fechadedefuncion+", nombrecliente="+nombrecliente+", relacion="
	+relacion+", costo="+costo+", cajon="+cajon+"fecha="+fecha+"]";
	}


	public List<Empleado> getEmpleados() {
		return empleados;
	}


	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}


	public int getIdentierro() {
		return identierro;
	}


	public void setIdentierro(int identierro) {
		this.identierro = identierro;
	}


	public String getNombrecliente() {
		return nombrecliente;
	}


	public void setNombrecliente(String nombrecliente) {
		this.nombrecliente = nombrecliente;
	}


	public String getFallecido() {
		return fallecido;
	}


	public void setFallecido(String fallecido) {
		this.fallecido = fallecido;
	}


	public String getRelacion() {
		return relacion;
	}


	public void setRelacion(String relacion) {
		this.relacion = relacion;
	}


	public String getCosto() {
		return costo;
	}


	public void setCosto(String costo) {
		this.costo = costo;
	}


	public String getCajon() {
		return cajon;
	}


	public void setCajon(String cajon) {
		this.cajon = cajon;
	}


	public String getFechadedefuncion() {
		return fechadedefuncion;
	}


	public void setFechadedefuncion(String fechadedefuncion) {
		this.fechadedefuncion = fechadedefuncion;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	} 
	
	
	
	
	
	
}
