package com.cibertec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cibertec.model.Producto;
import com.cibertec.service.ProductoService;

@Controller
public class ProductoController {
	@Autowired
    private ProductoService productoService;

   
    @GetMapping("/productos/nuevo")
    public String mostrarFormularioRegistro(Model model) {
    	Producto producto = new Producto();
        model.addAttribute("producto", producto);
        return "registro-producto";
    }

   
    @PostMapping("/productos/registrar")
    public String registrarProducto(@ModelAttribute("producto") Producto producto) throws Exception {
    	productoService.addProducto(producto);
        return "redirect:/productos/lista";
    }

   
    @GetMapping("/productos/lista")
    public String listarProductos(Model model) {
        List<Producto> productos = productoService.listarProducto();
        model.addAttribute("productos", productos);
        return "lista-productos";
    }
    @GetMapping("/productos/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable int id, Model model) {
        Producto producto = productoService.obtenerProductoPorId(id);
        model.addAttribute("producto", producto);
        return "editar-producto";
    }

    @PostMapping("/productos/actualizar")
    public String actualizarProducto(@ModelAttribute("producto") Producto producto) throws Exception {
        productoService.addProducto(producto); // Utilizamos el mismo método de guardado
        return "redirect:/productos/lista";
    }

    @GetMapping("/productos/eliminar/{id}")
    public String eliminarProducto(@PathVariable int id) {
        productoService.eliminarProducto(id);
        return "redirect:/productos/lista";
    }

    @GetMapping("/productos/detalles/{id}")
    public String verDetallesProducto(@PathVariable int id, Model model) {
        Producto producto = productoService.obtenerProductoPorId(id);
        model.addAttribute("producto", producto);
        return "detalles-producto";
    }


}
