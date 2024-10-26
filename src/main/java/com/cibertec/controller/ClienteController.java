package com.cibertec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cibertec.model.Cliente;
import com.cibertec.service.ClienteService;

@Controller
public class ClienteController {
	@Autowired
    private ClienteService clienteService;

   
    @GetMapping("/clientes/nuevo")
    public String mostrarFormularioRegistro(Model model) {
    	Cliente cliente = new Cliente();
        model.addAttribute("cliente", cliente);
        return "registro-cliente";
    }

   
    @PostMapping("/clientes/registrar")
    public String registrarCliente(@ModelAttribute("cliente") Cliente cliente) throws Exception {
    	clienteService.addCliente(cliente);
        return "redirect:/clientes/lista";
    }

   
    @GetMapping("/clientes/lista")
    public String listarClientes(Model model) {
        List<Cliente> clientes = clienteService.listarCliente();
        model.addAttribute("clientes", clientes);
        return "lista-clientes";
    }
    @GetMapping("/clientes/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable int id, Model model) {
    	Cliente cliente = clienteService.obtenerClientePorId(id);
        model.addAttribute("cliente", cliente);
        return "editar-cliente";
    }

    @PostMapping("/clientes/actualizar")
    public String actualizarCliente(@ModelAttribute("cliente") Cliente cliente) throws Exception {
    	clienteService.addCliente(cliente); // Utilizamos el mismo método de guardado
        return "redirect:/clientes/lista";
    }

    @GetMapping("/clientes/eliminar/{id}")
    public String eliminarCliente(@PathVariable int id) {
    	clienteService.eliminarCliente(id);
        return "redirect:/clientes/lista";
    }

    @GetMapping("/clientes/detalles/{id}")
    public String verDetallesCliente(@PathVariable int id, Model model) {
    	Cliente cliente = clienteService.obtenerClientePorId(id);
        model.addAttribute("cliente", cliente);
        return "detalles-cliente";
    }
}
