package cibertec.edu.pe.projectowebfinal.controller;

import cibertec.edu.pe.projectowebfinal.model.Categorias;
import cibertec.edu.pe.projectowebfinal.model.Producto;
import cibertec.edu.pe.projectowebfinal.repository.IProductoRepository;
import cibertec.edu.pe.projectowebfinal.request.ConsultaProductosRequest;
import cibertec.edu.pe.projectowebfinal.service.CategoriaService;
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
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/listadoProductos")
    public String listadoProductos(Model model){
        Producto producto= new Producto();
        model.addAttribute("lstProductos",productoService.getAllProductos());
        model.addAttribute("lstCategoria",categoriaService.getAllCategorias());
        model.addAttribute("producto",producto);
        return "Producto/ListarProductos";
    }

    @PostMapping("/saveProducto")
    public String saveProducto(@ModelAttribute("producto") Producto producto){
        productoService.saveProducto(producto);
        return "redirect:/Producto/listadoProductos";
    }


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


    @PostMapping("/consultar")
    public ResponseEntity<String> consultarProductos(@RequestBody ConsultaProductosRequest request) {
        // Extract the parameters from the request object
        String nombre = request.getDescripcion();
        String idTipo = request.getIdTipo();
        Integer estado = request.getEstado();

        // Your logic to search for productos based on the provided parameters
        List<Producto> productos;
        if (nombre != null && !nombre.trim().isEmpty()) {
            // Search by nombre
            productos = productoService.consultarProductosPorNombre(nombre);
        } else if (idTipo != null) {
            // Search by idtipo
            productos = productoService.consultarProductosPorIdTipo(idTipo);
        } else if (estado != 0) {
            // Search by estado
            productos = productoService.consultarProductosPorEstado(estado);
        } else {
            // No search criteria provided, return all productos
            productos = productoService.getAllProductos();
        }


        // Convert the list of productos to HTML markup using the ProductosService
        String htmlMarkup = productoService.convertProductosToHTML(productos);

        // Return the HTML markup as the response
        return ResponseEntity.ok(htmlMarkup);
        }



}
