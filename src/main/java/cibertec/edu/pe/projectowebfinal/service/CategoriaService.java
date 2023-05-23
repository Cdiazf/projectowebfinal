package cibertec.edu.pe.projectowebfinal.service;

import cibertec.edu.pe.projectowebfinal.model.Categorias;


import java.util.List;

public interface CategoriaService {
    List<Categorias> getAllCategorias();
    Categorias getCategoriaById(int idtipo);
    void saveCategoria(Categorias categorias);
    void deleteCategoryById(int idtipo);

}
