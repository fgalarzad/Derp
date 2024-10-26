package com.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cibertec.model.Empleado;
import com.cibertec.repository.EmpleadoRepository;

@Service
public class EmpleadoService {
	@Autowired
	private EmpleadoRepository empleadorepository;
	
	@Transactional
	public Empleado addEmpleado(Empleado empleado)throws Exception{
		Empleado saveEmpleadotoDB=this.empleadorepository.save(empleado);
		if (empleado.getIdempleado() != 0 && empleadorepository.existsById(empleado.getIdempleado())) {
	        return saveEmpleadotoDB;
	    } else {
	        return saveEmpleadotoDB;
	    }
	}
	public List<Empleado> listarEmpleado() {
        return empleadorepository.findAll();
    }
	public Empleado obtenerEmpleadoPorId(int id) {
	    return empleadorepository.findById(id).orElse(null);
	}
	public void eliminarEmpleado(int id) {
		empleadorepository.deleteById(id);
	}

}