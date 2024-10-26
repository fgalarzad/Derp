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
@Table(name="Ataudes")
public class Ataud {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idataud;
    private String tipomadera;
    private String color;
    private int stock;
    private String costo;

    @OneToMany(mappedBy = "ataud", cascade = CascadeType.ALL)
    private List<Entierro> entierros;

    @Override
    public String toString() 
	{
		return "Fallecido [idataud="+idataud+", tipomadera="+tipomadera+", color="+color
				+", stock="+stock+", costo="+costo+"]";
	}

	public int getIdataud() {
		return idataud;
	}

	public void setIdataud(int idataud) {
		this.idataud = idataud;
	}

	public String getTipomadera() {
		return tipomadera;
	}

	public void setTipomadera(String tipomadera) {
		this.tipomadera = tipomadera;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getCosto() {
		return costo;
	}

	public void setCosto(String costo) {
		this.costo = costo;
	}

	public List<Entierro> getEntierros() {
		return entierros;
	}

	public void setEntierros(List<Entierro> entierros) {
		this.entierros = entierros;
	}
    
}

