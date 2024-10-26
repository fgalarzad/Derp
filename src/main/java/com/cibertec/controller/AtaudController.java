package com.cibertec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cibertec.model.Ataud;
import com.cibertec.service.AtaudService;

@Controller
public class AtaudController {

	@Autowired
    private AtaudService ataudService;

   
    @GetMapping("/ataudes/nuevo")
    public String mostrarFormularioRegistro(Model model) {
    	Ataud ataud = new Ataud();
        model.addAttribute("ataud", ataud);
        return "registro-ataud";
    }

   
    @PostMapping("/ataudes/registrar")
    public String registrarAtaud(@ModelAttribute("ataud") Ataud ataud) throws Exception {
    	ataudService.addAtaud(ataud);
        return "redirect:/ataudes/lista";
    }

   
    @GetMapping("/ataudes/lista")
    public String listarAtaudes(Model model) {
        List<Ataud> ataudes = ataudService.listarAtaud();
        model.addAttribute("ataudes", ataudes);
        return "lista-ataudes";
    }
    @GetMapping("/ataudes/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable int id, Model model) {
    	Ataud ataud = ataudService.obtenerAtaudPorId(id);
        model.addAttribute("ataud", ataud);
        return "editar-ataud";
    }

    @PostMapping("/ataudes/actualizar")
    public String actualizarAtaud(@ModelAttribute("ataud") Ataud ataud) throws Exception {
    	ataudService.addAtaud(ataud); // Utilizamos el mismo método de guardado
        return "redirect:/ataudes/lista";
    }

    @GetMapping("/ataudes/eliminar/{id}")
    public String eliminarAtaud(@PathVariable int id) {
    	ataudService.eliminarAtaud(id);
        return "redirect:/ataudes/lista";
    }

    @GetMapping("/ataudes/detalles/{id}")
    public String verDetallesAtaud(@PathVariable int id, Model model) {
    	Ataud ataud = ataudService.obtenerAtaudPorId(id);
        model.addAttribute("ataud", ataud);
        return "detalles-ataud";
    }

}
