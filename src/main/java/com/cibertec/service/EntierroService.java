package com.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cibertec.model.Entierro;
import com.cibertec.repository.EntierroRepository;

@Service
public class EntierroService {
	@Autowired
	private EntierroRepository entierrorepository;
	
	@Transactional
	public Entierro addEntierro(Entierro entierro)throws Exception{
		Entierro saveEntierrotoDB=this.entierrorepository.save(entierro);
		if (entierro.getIdentierro() != 0 && entierrorepository.existsById(entierro.getIdentierro())) {
	        return saveEntierrotoDB;
	    } else {
	        return saveEntierrotoDB;
	    }
	}
	public List<Entierro> listarEntierro() {
        return entierrorepository.findAll();
    }
	public Entierro obtenerEntierroPorId(int id) {
	    return entierrorepository.findById(id).orElse(null);
	}
	public void eliminarEntierro(int id) {
		entierrorepository.deleteById(id);
	}


}
