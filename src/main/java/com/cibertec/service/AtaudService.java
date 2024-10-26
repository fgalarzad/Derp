package com.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cibertec.model.Ataud;
import com.cibertec.repository.AtaudRepository;

@Service
public class AtaudService {
	@Autowired
	private AtaudRepository ataudrepository;
	
	@Transactional
	public Ataud addAtaud(Ataud ataud)throws Exception{
		Ataud saveAtaudtoDB=this.ataudrepository.save(ataud);
		if (ataud.getIdataud() != 0 && ataudrepository.existsById(ataud.getIdataud())) {
	        return saveAtaudtoDB;
	    } else {
	        return saveAtaudtoDB;
	    }
	}
	public List<Ataud> listarAtaud() {
        return ataudrepository.findAll();
    }
	public Ataud obtenerAtaudPorId(int id) {
	    return ataudrepository.findById(id).orElse(null);
	}
	public void eliminarAtaud(int id) {
		ataudrepository.deleteById(id);
	}
}
