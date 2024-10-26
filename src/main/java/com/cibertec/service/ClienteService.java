package com.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cibertec.model.Cliente;
import com.cibertec.repository.ClienteRepository;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository clienterepository;
	
	@Transactional
	public Cliente addCliente(Cliente cliente)throws Exception{
		Cliente saveClientetoDB=this.clienterepository.save(cliente);
		if (cliente.getIdcliente() != 0 && clienterepository.existsById(cliente.getIdcliente())) {
	        return saveClientetoDB;
	    } else {
	        return saveClientetoDB;
	    }
	}
	public List<Cliente> listarCliente() {
        return clienterepository.findAll();
    }
	public Cliente obtenerClientePorId(int id) {
	    return clienterepository.findById(id).orElse(null);
	}
	public void eliminarCliente(int id) {
		clienterepository.deleteById(id);
	}

}
