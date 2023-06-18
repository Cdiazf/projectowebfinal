package cibertec.edu.pe.projectowebfinal.service;

import cibertec.edu.pe.projectowebfinal.model.Categorias;
import cibertec.edu.pe.projectowebfinal.model.Producto;
import cibertec.edu.pe.projectowebfinal.repository.ICategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService{

    @Autowired
    private ICategoriaRepository categoriaRepository;
    @Override
    public List<Categorias> getAllCategorias() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categorias getCategoriaById(Integer idtipo) {
        Optional<Categorias> optional=categoriaRepository.findById(idtipo);
        Categorias categorias=null;
        if(optional.isPresent()){
            categorias=optional.get();
        }else{
            throw new RuntimeException("Categoria no encontrado con el ID::"+idtipo);
        }
        return categorias;
    }

    @Override
    public void saveCategoria(Categorias categorias) {
         this.categoriaRepository.save(categorias);
    }

    @Override
    public void deleteCategoryById(Integer idtipo) {
        this.categoriaRepository.deleteById(idtipo);
    }
}
