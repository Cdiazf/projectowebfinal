package cibertec.edu.pe.projectowebfinal.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;

import cibertec.edu.pe.projectowebfinal.model.Producto;
import cibertec.edu.pe.projectowebfinal.model.Proveedor;

import cibertec.edu.pe.projectowebfinal.service.ProveedorService;

@Controller
@RequestMapping("/Proveedor")
public class ProveedorController {

	@Autowired
	private ProveedorService proveedorsevice;

	 @GetMapping("/listadoProveedor")
	    public String listadoProveedor(Model model){
	        Proveedor proveedor= new Proveedor();
	        model.addAttribute("lstProveedor",proveedorsevice.getAllProveedores());
	        model.addAttribute("proveedor",proveedor);
	        return "Proveedor/ListarProveedor";
	    }

	    @PostMapping("/saveProveedor")
	    public String saveProveedor(@ModelAttribute("proveedor")Proveedor proveedor){
	        proveedorsevice.saveProveedor(proveedor);
	        return "redirect:/Proveedor/listadoProveedor";
	    }
	    
	   
	    @GetMapping("/updateProveedor/{idprov}")
	    public ResponseEntity<Proveedor> updateProveedor(@PathVariable(value = "idprov") String idprov) {
	        // Get the product from the service
	        Proveedor proveedor = proveedorsevice.getProveedorById(idprov);

	        if (proveedor == null) {
	            // Return an appropriate response if the product is not found
	            return ResponseEntity.notFound().build();
	        }

	        // Return the product in the response body
	        return ResponseEntity.ok(proveedor);
	    }
	    
	    
	    	   

	    @GetMapping("/deleteProveedor/{idprov}")
	    public String deleteProveedor(@PathVariable(value="idprov") String idprov) {
	        this.proveedorsevice.deleteProveedorById(idprov);
	        return "redirect:/Proveedor/listadoProveedor";
	    }
	    
	    @GetMapping("/consultar")
	    public List<Proveedor> consultarProveedor(@RequestParam(required = false) String nombre,
	                                             @RequestParam(required = false) Long idProv) {
	        // Check which parameters are provided and call the corresponding service method

	        if (nombre != null) {
	            // Search by nombre
	            return proveedorsevice.consultarProveedorPorNombre(nombre);
	        } else if (idProv != null) {
	            // Search by idtipo
	            return proveedorsevice.consultarProveedorPorIdProv(idProv);
	        } else {
	            // No search criteria provided, return all productos
	            return proveedorsevice.getAllProveedores();
	        }
	    }
}
