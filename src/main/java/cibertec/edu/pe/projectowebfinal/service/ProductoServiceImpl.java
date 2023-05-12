package cibertec.edu.pe.projectowebfinal.service;

import cibertec.edu.pe.projectowebfinal.model.Producto;
import cibertec.edu.pe.projectowebfinal.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService{
    @Autowired
    private IProductoRepository productoRepository;
    @Override
    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    @Override
    public void saveProducto(Producto producto) {
        this.productoRepository.save(producto);
    }

    @Override
    public Producto getProductoById(String idprod) {
        Optional<Producto> optional=productoRepository.findById(idprod);
        Producto producto=null;
        if(optional.isPresent()){
            producto=optional.get();
        }else{
            throw new RuntimeException("Producto no encontrado con el ID::"+idprod);
        }
        return producto;
    }

    @Override
    public void deleteProductoById(String idprod) {
        this.productoRepository.deleteById(idprod);
    }


}
