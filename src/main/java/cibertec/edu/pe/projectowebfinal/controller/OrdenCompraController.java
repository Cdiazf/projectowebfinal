package cibertec.edu.pe.projectowebfinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import cibertec.edu.pe.projectowebfinal.model.OrdenCompra;
import cibertec.edu.pe.projectowebfinal.service.OrdenCompraService;
import cibertec.edu.pe.projectowebfinal.service.ProveedorService;

@Controller
@RequestMapping("/Orden")
public class OrdenCompraController {
	@Autowired
	private OrdenCompraService ordenCompraService;
	@Autowired
	private ProveedorService proveedorService;

	//private UsuarioService usuarioService;
	
	@GetMapping("/listadoOrden")
	public String listadoOrden( Model model) {
		OrdenCompra ordenCompra=new OrdenCompra();
		model.addAttribute("lstOrden",ordenCompraService.getAllOrdenCompras());
		model.addAttribute("lstProveedor",proveedorService.getAllProveedores());
		//model.addAttribute("lstUsuario",usuarioService.getAllUsuarios());
		model.addAttribute("ordenCompra",ordenCompra);
		return "Orden/ListarOrden";
	}

	@PostMapping("/saveOrden")
	public String saveOrden(@ModelAttribute("ordenCompra") OrdenCompra ordenCompra) {
		ordenCompraService.saveOrden(ordenCompra);
		return "redirect:/Orden/listadoOrden";
	}
	
	@GetMapping("/updateOrden/{idorden}")
	public ResponseEntity<OrdenCompra> updateOrden(@PathVariable(value="idorden") String idorden){
		OrdenCompra orden = ordenCompraService.getOrdenById(idorden);
		
		if(orden==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(orden);
	}
	
	@GetMapping("/deleteOrden/{idorden}")
	public String deleteOrden(@PathVariable(value="idorden") String idorden) {
		this.ordenCompraService.deleteOrdenById(idorden);
		return "redirect:/Orden/listadoOrden";
	}
}
