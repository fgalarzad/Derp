package com.cibertec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cibertec.model.Fallecido;
import com.cibertec.service.FallecidoService;

@Controller
public class FallecidoController {
	@Autowired
    private FallecidoService fallecidoService;

   
    @GetMapping("/fallecidos/nuevo")
    public String mostrarFormularioRegistro(Model model) {
    	Fallecido fallecido = new Fallecido();
        model.addAttribute("fallecido", fallecido);
        return "registro-fallecido";
    }

   
    @PostMapping("/fallecidos/registrar")
    public String registrarFallecido(@ModelAttribute("fallecido") Fallecido fallecido) throws Exception {
    	fallecidoService.addFallecido(fallecido);
        return "redirect:/fallecidos/lista";
    }

   
    @GetMapping("/fallecidos/lista")
    public String listarFallecidos(Model model) {
        List<Fallecido> fallecidos = fallecidoService.listarFallecido();
        model.addAttribute("fallecidos", fallecidos);
        return "lista-fallecidos";
    }
    @GetMapping("/fallecidos/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable int id, Model model) {
    	Fallecido fallecido = fallecidoService.obtenerFallecidoPorId(id);
        model.addAttribute("fallecido", fallecido);
        return "editar-fallecido";
    }

    @PostMapping("/fallecidos/actualizar")
    public String actualizarFallecido(@ModelAttribute("fallecido") Fallecido fallecido) throws Exception {
    	fallecidoService.addFallecido(fallecido); // Utilizamos el mismo método de guardado
        return "redirect:/fallecidos/lista";
    }

    @GetMapping("/fallecidos/eliminar/{id}")
    public String eliminarFallecido(@PathVariable int id) {
    	fallecidoService.eliminarFallecido(id);
        return "redirect:/fallecidos/lista";
    }

    @GetMapping("/fallecidos/detalles/{id}")
    public String verDetallesFallecido(@PathVariable int id, Model model) {
    	Fallecido fallecido = fallecidoService.obtenerFallecidoPorId(id);
        model.addAttribute("fallecido", fallecido);
        return "detalles-fallecido";
    }

}
