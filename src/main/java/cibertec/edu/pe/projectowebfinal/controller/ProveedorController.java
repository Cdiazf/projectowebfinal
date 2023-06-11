package cibertec.edu.pe.projectowebfinal.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lowagie.text.DocumentException;

import cibertec.edu.pe.projectowebfinal.model.Proveedor;
import cibertec.edu.pe.projectowebfinal.reportes.ProveedorExporterExcel;
import cibertec.edu.pe.projectowebfinal.reportes.ProveedorExporterPDF;
import cibertec.edu.pe.projectowebfinal.service.ProveedorService;

@Controller

public class ProveedorController {

	@Autowired
	private ProveedorService proveedorsevice;

	@GetMapping("/Proveedor/showProveedor/{idprov}")
    public ResponseEntity<Proveedor> showProveedor(@PathVariable(value = "idprov") String idprov) {
        // Get the product from the service
        Proveedor proveedor = proveedorsevice.getProveedorById(idprov);

        if (proveedor == null) {
            // Return an appropriate response if the product is not found
            return ResponseEntity.notFound().build();
        }

        // Return the product in the response body
        return ResponseEntity.ok(proveedor);
    }
	
				
	 @GetMapping("/Proveedor/listadoProveedor")
	    public String listadoProveedor(Model model){
	        Proveedor proveedor= new Proveedor();
	        model.addAttribute("lstProveedor",proveedorsevice.getAllProveedores());
	        model.addAttribute("proveedor",proveedor);
	        return "Proveedor/ListarProveedor";
	    }

	    @PostMapping("/Proveedor/saveProveedor")
	    public String saveProveedor(@ModelAttribute("proveedor")Proveedor proveedor){
	        proveedorsevice.saveProveedor(proveedor);
	        return "redirect:/Proveedor/listadoProveedor";
	    }
	    
	   
	    @GetMapping("/Proveedor/updateProveedor/{idprov}")
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
	    
	    
	    	   

	    @GetMapping("/Proveedor/deleteProveedor/{idprov}")
	    public String deleteProveedor(@PathVariable(value="idprov") String idprov) {
	        this.proveedorsevice.deleteProveedorById(idprov);
	        return "redirect:/Proveedor/listadoProveedor";
	    }
	    
	    
	    @GetMapping("/exportarPDF")
		public void exportarListadoDeProveedoresEnPDF(HttpServletResponse response) throws DocumentException, IOException {
			response.setContentType("application/pdf");
			
			DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
			String fechaActual = dateFormatter.format(new Date());
			
			String cabecera = "Content-Disposition";
			String valor = "attachment; filename=Proveedores_" + fechaActual + ".pdf";
			
			response.setHeader(cabecera, valor);
			
			List<Proveedor> proveedores = proveedorsevice.getAllProveedores();
			
			ProveedorExporterPDF exporter = new ProveedorExporterPDF(proveedores);
			exporter.exportar(response);
		}
		
	   
	    @GetMapping("/exportarExcel")
		public void exportarListadoDeProveedoresEnExcel(HttpServletResponse response) throws DocumentException, IOException {
			response.setContentType("application/octet-stream");
			
			DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
			String fechaActual = dateFormatter.format(new Date());
			
			String cabecera = "Content-Disposition";
			String valor = "attachment; filename=Proveedores_" + fechaActual + ".xlsx";
			
			response.setHeader(cabecera, valor);
			
			List<Proveedor> proveedores = proveedorsevice.getAllProveedores();
			
			ProveedorExporterExcel exporter = new ProveedorExporterExcel(proveedores);
			exporter.exportar(response);
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
