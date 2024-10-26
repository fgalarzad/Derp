package com.cibertec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cibertec.model.Entierro;
import com.cibertec.service.EntierroService;

@Controller
public class EntierroController {
	@Autowired
    private EntierroService entierroService;

   
    @GetMapping("/entierros/nuevo")
    public String mostrarFormularioRegistro(Model model) {
    	Entierro entierro = new Entierro();
        model.addAttribute("entierro", entierro);
        return "registro-entierro";
    }

   
    @PostMapping("/entierros/registrar")
    public String registrarEntierro(@ModelAttribute("entierro") Entierro entierro) throws Exception {
    	entierroService.addEntierro(entierro);
        return "redirect:/entierros/lista";
    }

   
    @GetMapping("/entierros/lista")
    public String listarEntierros(Model model) {
        List<Entierro> entierros = entierroService.listarEntierro();
        model.addAttribute("entierros", entierros);
        return "lista-entierros";
    }
    @GetMapping("/entierros/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable int id, Model model) {
    	Entierro entierro = entierroService.obtenerEntierroPorId(id);
        model.addAttribute("entierro", entierro);
        return "editar-entierro";
    }

    @PostMapping("/entierros/actualizar")
    public String actualizarEntierro(@ModelAttribute("entierro") Entierro entierro) throws Exception {
    	entierroService.addEntierro(entierro); // Utilizamos el mismo método de guardado
        return "redirect:/entierros/lista";
    }

    @GetMapping("/entierros/eliminar/{id}")
    public String eliminarProducto(@PathVariable int id) {
    	entierroService.eliminarEntierro(id);
        return "redirect:/entierros/lista";
    }

    @GetMapping("/entierros/detalles/{id}")
    public String verDetallesProducto(@PathVariable int id, Model model) {
    	Entierro entierro = entierroService.obtenerEntierroPorId(id);
        model.addAttribute("entierro", entierro);
        return "detalles-entierro";
    }


}
