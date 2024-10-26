package com.cibertec.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name="Fallecidos")
public class Fallecido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idfallecido;
    private String nombrefallecido;
    private String fechadedefuncion;
    private String causademuerte;

    @OneToMany(mappedBy = "fallecido", cascade = CascadeType.ALL)
    private List<Entierro> entierros;

    @Override
    public String toString() 
	{
		return "Fallecido [idfallecido="+idfallecido+", nombrefallecido="+nombrefallecido+", fechadedefuncion="+fechadedefuncion
				+", causademuerte="+causademuerte+"]";
	}

	public int getIdfallecido() {
		return idfallecido;
	}

	public void setIdfallecido(int idfallecido) {
		this.idfallecido = idfallecido;
	}

	public String getNombrefallecido() {
		return nombrefallecido;
	}

	public void setNombrefallecido(String nombrefallecido) {
		this.nombrefallecido = nombrefallecido;
	}

	public String getFechadedefuncion() {
		return fechadedefuncion;
	}

	public void setFechadedefuncion(String fechadedefuncion) {
		this.fechadedefuncion = fechadedefuncion;
	}

	public String getCausademuerte() {
		return causademuerte;
	}

	public void setCausademuerte(String causademuerte) {
		this.causademuerte = causademuerte;
	}

	public List<Entierro> getEntierros() {
		return entierros;
	}

	public void setEntierros(List<Entierro> entierros) {
		this.entierros = entierros;
	}
    
}

