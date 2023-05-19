package cibertec.edu.pe.projectowebfinal.service;

import cibertec.edu.pe.projectowebfinal.model.Producto;

import java.util.List;

public interface ProductoService {

    List<Producto> getAllProductos();
    void saveProducto(Producto proveedor);

    Producto getProductoById(String idprod);
    void deleteProductoById(String idprod);
    List<Producto> consultarProductosPorNombre(String consulta);

    List<Producto> consultarProductosPorIdTipo(Long idTipo);

    List<Producto> consultarProductosPorEstado(String estado);
}
