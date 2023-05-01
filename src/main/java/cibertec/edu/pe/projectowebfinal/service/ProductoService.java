package cibertec.edu.pe.projectowebfinal.service;

import cibertec.edu.pe.projectowebfinal.model.Producto;

import java.util.List;

public interface ProductoService {

    List<Producto> getAllProductos();
    void saveProducto(Producto proveedor);
    Producto getProductoById(String id);
    void deleteProductoById(String id);

}
