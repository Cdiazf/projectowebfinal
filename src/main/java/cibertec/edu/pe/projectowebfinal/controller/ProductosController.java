package cibertec.edu.pe.projectowebfinal.controller;

import cibertec.edu.pe.projectowebfinal.model.Producto;
import cibertec.edu.pe.projectowebfinal.repository.IProductoRepository;
import cibertec.edu.pe.projectowebfinal.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/updateProducto/{idprod}")
    public String updateProducto(@PathVariable(value = "idprod") String idprod, Model model) {
        // get producto from the service
        Producto producto = productoService.getProductoById(idprod);
        System.out.print(idprod);

        // set producto as a model attribute to pre-populate the form
        model.addAttribute("producto", producto);
        return "redirect:/Producto/listadoProductos";

    }

    @GetMapping("/deleteProducto/{idprod}")
    public String deleteProducto(@PathVariable(value="idprod") String idprod) {
        this.productoService.deleteProductoById(idprod);
        return "redirect:/Producto/listadoProductos";
    }

}
