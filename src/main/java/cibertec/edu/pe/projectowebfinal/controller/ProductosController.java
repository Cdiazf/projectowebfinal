package cibertec.edu.pe.projectowebfinal.controller;

import cibertec.edu.pe.projectowebfinal.model.Producto;
import cibertec.edu.pe.projectowebfinal.repository.IProductoRepository;
import cibertec.edu.pe.projectowebfinal.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
