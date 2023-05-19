package cibertec.edu.pe.projectowebfinal.controller;

import cibertec.edu.pe.projectowebfinal.model.Producto;
import cibertec.edu.pe.projectowebfinal.repository.IProductoRepository;
import cibertec.edu.pe.projectowebfinal.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/Producto")
public class ProductosController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/listadoProductos")
    public String listadoProductos(Model model){
        Producto producto= new Producto();
        model.addAttribute("lstProductos",productoService.getAllProductos());
        model.addAttribute("producto",producto);
        return "Producto/ListarProductos";
    }

    @PostMapping("/saveProducto")
    public String saveProducto(@ModelAttribute("producto")Producto producto){
        productoService.saveProducto(producto);
        return "redirect:/Producto/listadoProductos";
    }

//    @GetMapping("/updateProducto/{idprod}")
//    public String updateProducto(@PathVariable(value = "idprod") String idprod, Model model) {
//        // get producto from the service
//        Producto producto = productoService.getProductoById(idprod);
//        System.out.print(idprod);
//
//        // set producto as a model attribute to pre-populate the form
//        model.addAttribute("producto", producto);
//        return "/updateProducto/{idprod}";
//
//    }
//
//    @GetMapping("/updateProducto")
//    public String updateProducto(@RequestParam("idprod") String idprod, Model model) {
//        // Get the product from the service
//        Producto producto = productoService.getProductoById(idprod);
//
//        // Set the product as a model attribute to pre-populate the form
//        model.addAttribute("producto", producto);
//
//        return "redirect:/Producto/listadoProductos";
//    }

    @GetMapping("/updateProducto/{idprod}")
    public ResponseEntity<Producto> updateProducto(@PathVariable(value = "idprod") String idprod) {
        // Get the product from the service
        Producto producto = productoService.getProductoById(idprod);

        if (producto == null) {
            // Return an appropriate response if the product is not found
            return ResponseEntity.notFound().build();
        }

        // Return the product in the response body
        return ResponseEntity.ok(producto);
    }


    @GetMapping("/deleteProducto/{idprod}")
    public String deleteProducto(@PathVariable(value="idprod") String idprod) {
        this.productoService.deleteProductoById(idprod);
        return "redirect:/Producto/listadoProductos";
    }

    @GetMapping("/consultar")
    public List<Producto> consultarProductos(@RequestParam(required = false) String nombre,
                                             @RequestParam(required = false) Long idTipo,
                                             @RequestParam(required = false) String estado) {
        // Check which parameters are provided and call the corresponding service method

        if (nombre != null) {
            // Search by nombre
            return productoService.consultarProductosPorNombre(nombre);
        } else if (idTipo != null) {
            // Search by idtipo
            return productoService.consultarProductosPorIdTipo(idTipo);
        } else if (estado != null) {
            // Search by estado
            return productoService.consultarProductosPorEstado(estado);
        } else {
            // No search criteria provided, return all productos
            return productoService.getAllProductos();
        }
    }



}
