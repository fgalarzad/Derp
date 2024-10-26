package com.cibertec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cibertec.model.Empleado;
import com.cibertec.model.Entierro;

import com.cibertec.service.EmpleadoService;
import com.cibertec.service.EntierroService;

@Controller
public class EmpleadoController {
	
	@Autowired
    private EmpleadoService empleadoService;

	@Autowired
    private EntierroService entierroService;
	
    @GetMapping("/empleados/nuevo")
    public String mostrarFormularioRegistro(Model model) {
    	Empleado empleado = new Empleado();
    	List<Entierro> entierros = entierroService.listarEntierro();
        model.addAttribute("empleado", empleado);
        model.addAttribute("entierros", entierros);
        return "registro-empleado";
    }
   
    @PostMapping("/empleados/registrar")
    public String registrarEmpleado(@ModelAttribute("empleado") Empleado empleado) throws Exception {
    	Entierro entierro = entierroService.obtenerEntierroPorId(empleado.getEntierro().getIdentierro());
        empleado.setEntierro(entierro);
    	empleadoService.addEmpleado(empleado);
        return "redirect:/empleados/lista";
    }

   
    @GetMapping("/empleados/lista")
    public String listarEmpleados(Model model) {
        List<Empleado> empleados = empleadoService.listarEmpleado();
        model.addAttribute("empleados", empleados);
        return "lista-empleados";
    }
    @GetMapping("/empleados/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable int id, Model model) {
    	Empleado empleado = empleadoService.obtenerEmpleadoPorId(id);
        List<Entierro> entierros = entierroService.listarEntierro();
        model.addAttribute("empleado", empleado);
        model.addAttribute("entierros", entierros);
        return "editar-empleado";
    }

    @PostMapping("/empleados/actualizar")
    public String actualizarEmpleado(@ModelAttribute("empleado") Empleado empleado) throws Exception {
    	Entierro entierros = entierroService.obtenerEntierroPorId(empleado.getEntierro().getIdentierro());
        empleado.setEntierro(entierros);
    	empleadoService.addEmpleado(empleado); // Utilizamos el mismo método de guardado
        return "redirect:/empleados/lista";
    }

    @GetMapping("/empleados/eliminar/{id}")
    public String eliminarEmpleado(@PathVariable int id) {
    	empleadoService.eliminarEmpleado(id);
        return "redirect:/empleados/lista";
    }

    @GetMapping("/empleados/detalles/{id}")
    public String verDetallesEmpleado(@PathVariable int id, Model model) {
    	Empleado empleado = empleadoService.obtenerEmpleadoPorId(id);
        model.addAttribute("empleado", empleado);
        return "detalles-empleado";
    }

}
