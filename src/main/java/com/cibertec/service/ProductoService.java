package com.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cibertec.model.Producto;
import com.cibertec.repository.ProductoRepository;

@Service
public class ProductoService {
	@Autowired
	private ProductoRepository productorepository;
	
	@Transactional
	public Producto addProducto(Producto producto)throws Exception{
		Producto saveProductotoDB=this.productorepository.save(producto);
		if (producto.getIdproducto() != 0 && productorepository.existsById(producto.getIdproducto())) {
	        return saveProductotoDB;
	    } else {
	        return saveProductotoDB;
	    }
	}
	public List<Producto> listarProducto() {
        return productorepository.findAll();
    }
	public Producto obtenerProductoPorId(int id) {
	    return productorepository.findById(id).orElse(null);
	}
	public void eliminarProducto(int id) {
	    productorepository.deleteById(id);
	}


}
