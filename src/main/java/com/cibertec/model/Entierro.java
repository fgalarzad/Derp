package com.cibertec.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Entierros")
public class Entierro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int identierro;
	 private String relacion;
	    private String fecha;

    @ManyToOne
	@JoinColumn(name = "idcliente", nullable = false)
	private Cliente cliente;

	@ManyToOne
	@JoinColumn(name = "idfallecido", nullable = false)
	private Fallecido fallecido;

	@ManyToOne
	@JoinColumn(name = "idataud", nullable = false)
	private Ataud ataud;
	
	@OneToMany(mappedBy = "entierro", cascade = CascadeType.ALL)
    private List<Empleado> empleados;
	
	@Override
	public String toString() 
	{
		return "Producto [identierro="+identierro+", fallecido="+fallecido+", cliente="+cliente+", ataud="+ataud+", relacion="
	+relacion+"fecha="+fecha+"]";
	}


	public List<Empleado> getEmpleados() {
		return empleados;
	}


	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Fallecido getFallecido() {
		return fallecido;
	}


	public void setFallecido(Fallecido fallecido) {
		this.fallecido = fallecido;
	}


	public Ataud getAtaud() {
		return ataud;
	}


	public void setAtaud(Ataud ataud) {
		this.ataud = ataud;
	}


	public int getIdentierro() {
		return identierro;
	}


	public void setIdentierro(int identierro) {
		this.identierro = identierro;
	}




	public String getRelacion() {
		return relacion;
	}


	public void setRelacion(String relacion) {
		this.relacion = relacion;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	} 
	
	
	
	
	
	
}
