package cibertec.edu.pe.projectowebfinal.controller;

import cibertec.edu.pe.projectowebfinal.model.Categorias;
import cibertec.edu.pe.projectowebfinal.model.Producto;
import cibertec.edu.pe.projectowebfinal.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/Categoria")

public class CategoriasController {
    @Autowired
    private CategoriaService categoriaService;
    @GetMapping("/listarCategorias")
    public String listarCategorias(Model model){
        Categorias categorias = new Categorias();
        model.addAttribute("lstcategoria",categoriaService.getAllCategorias());
        model.addAttribute("categorias",categorias);
        return "Categoria/ListarCategorias";
    }

    @PostMapping("/saveCategoria")
    public String saveCategoria(@ModelAttribute("categorias") Categorias categorias){
        categoriaService.saveCategoria(categorias);
        return "redirect:/Categoria/listarCategorias";
    }

    @GetMapping("/deleteCategoria/{idtipo}")
    public String deleteCategoria(@PathVariable(value = "idtipo") Integer idtipo){
        this.categoriaService.deleteCategoryById(idtipo);
        return "redirect:/Categoria/listarCategorias";
    }
}
