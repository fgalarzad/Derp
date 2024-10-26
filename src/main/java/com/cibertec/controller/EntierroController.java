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
import com.cibertec.model.Cliente;
import com.cibertec.model.Entierro;
import com.cibertec.model.Fallecido;
import com.cibertec.service.AtaudService;
import com.cibertec.service.ClienteService;
import com.cibertec.service.EntierroService;
import com.cibertec.service.FallecidoService;

@Controller
public class EntierroController {
	@Autowired
    private EntierroService entierroService;
	@Autowired
    private ClienteService clienteService;
	@Autowired
    private FallecidoService fallecidoService;
	@Autowired
    private AtaudService ataudService;
   
    @GetMapping("/entierros/nuevo")
    public String mostrarFormularioRegistro(Model model) {
    	Entierro entierro = new Entierro();
    	List<Cliente> clientes = clienteService.listarCliente();
    	List<Fallecido> fallecidos = fallecidoService.listarFallecido();
    	List<Ataud> ataudes = ataudService.listarAtaud();
        model.addAttribute("entierro", entierro);
        model.addAttribute("clientes", clientes);
        model.addAttribute("fallecidos", fallecidos);
        model.addAttribute("ataudes", ataudes);
        
        return "registro-entierro";
    }

   
    @PostMapping("/entierros/registrar")
    public String registrarEntierro(@ModelAttribute("entierro") Entierro entierro) throws Exception {
    	Cliente cliente = clienteService.obtenerClientePorId(entierro.getCliente().getIdcliente());
    	Fallecido fallecido = fallecidoService.obtenerFallecidoPorId(entierro.getFallecido().getIdfallecido());
    	Ataud ataud = ataudService.obtenerAtaudPorId(entierro.getAtaud().getIdataud());
    	entierro.setCliente(cliente);
    	entierro.setFallecido(fallecido);
    	entierro.setAtaud(ataud);
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

    @PostMapping("/Atauds/actualizar")
    public String actualizarEntierro(@ModelAttribute("entierro") Entierro entierro) throws Exception {
    	entierroService.addEntierro(entierro); // Utilizamos el mismo método de guardado
        return "redirect:/entierros/lista";
    }

    @GetMapping("/entierros/eliminar/{id}")
    public String eliminarEntierro(@PathVariable int id) {
    	entierroService.eliminarEntierro(id);
        return "redirect:/entierros/lista";
    }

    @GetMapping("/entierros/detalles/{id}")
    public String verDetallesEntierro(@PathVariable int id, Model model) {
    	Entierro entierro = entierroService.obtenerEntierroPorId(id);
        model.addAttribute("entierro", entierro);
        return "detalles-entierro";
    }


}
