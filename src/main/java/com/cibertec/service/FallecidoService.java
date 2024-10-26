package com.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cibertec.model.Fallecido;
import com.cibertec.repository.FallecidoRepository;

@Service
public class FallecidoService {
	
	@Autowired
	private FallecidoRepository fallecidorepository;
	
	@Transactional
	public Fallecido addFallecido(Fallecido fallecido)throws Exception{
		Fallecido saveFallecidotoDB=this.fallecidorepository.save(fallecido);
		if (fallecido.getIdfallecido() != 0 && fallecidorepository.existsById(fallecido.getIdfallecido())) {
	        return saveFallecidotoDB;
	    } else {
	        return saveFallecidotoDB;
	    }
	}
	public List<Fallecido> listarFallecido() {
        return fallecidorepository.findAll();
    }
	public Fallecido obtenerFallecidoPorId(int id) {
	    return fallecidorepository.findById(id).orElse(null);
	}
	public void eliminarFallecido(int id) {
		fallecidorepository.deleteById(id);
	}
}
