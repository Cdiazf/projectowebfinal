package cibertec.edu.pe.projectowebfinal.service;

import cibertec.edu.pe.projectowebfinal.model.Producto;
import cibertec.edu.pe.projectowebfinal.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Override
    public List<Producto> consultarProductosPorNombre(String nombre) {
        List<Producto> productosConsultados = new ArrayList<>();

        // consultar producto por descripcion
        for (Producto producto: getAllProductos()){
            if (producto.getDescripcion().toLowerCase().contains(nombre.toLowerCase())){
                productosConsultados.add(producto);
            }
        }
        return productosConsultados;
    }

    @Override
    public List<Producto> consultarProductosPorIdTipo(String nombreCategoria) {
        List<Producto> productosConsultados = new ArrayList<>();
        for(Producto producto:getAllProductos()){
            if (producto.getCategoria().getNombrecategoria().toLowerCase().contains(nombreCategoria.toLowerCase())){
                productosConsultados.add(producto);
            }
        }
        return productosConsultados;
    }

    @Override
    public List<Producto> consultarProductosPorEstado(Integer estado) {
        List<Producto> productosConsultados = new ArrayList<>();

        // Consultar productos por estado
        for (Producto producto : getAllProductos()) {
            if (producto.getEstado()== estado) {
                productosConsultados.add(producto);
            }
        }
        return productosConsultados;
    }

    @Override
    public String convertProductosToHTML(List<Producto> productos) {
        StringBuilder htmlBuilder = new StringBuilder();
        for (Producto producto : productos) {
            htmlBuilder.append("<tr>");
            htmlBuilder.append("<td><h2 class='table-avatar'>");
            htmlBuilder.append("<a href='#' class='avatar'><img alt='' src='#'></a>");
            htmlBuilder.append("<a href='#'>John Doe <span>Web Designer</span></a>");
            htmlBuilder.append("</h2></td>");
            htmlBuilder.append("<td>").append(producto.getIdprod()).append("</td>");
            htmlBuilder.append("<td>").append(producto.getDescripcion()).append("</td>");
            htmlBuilder.append("<td>").append(producto.getEstado()).append("</td>");
            htmlBuilder.append("<td>").append(producto.getCategoria().getNombrecategoria()).append("</td>");
            htmlBuilder.append("<td>").append(producto.getPrecio()).append("</td>");
            htmlBuilder.append("<td>").append(producto.getStock()).append("</td>");
            htmlBuilder.append("<td class='text-right'>");
            htmlBuilder.append("<div class='dropdown dropdown-action'>");
            htmlBuilder.append("<a href='#' class='action-icon dropdown-toggle' data-toggle='dropdown' aria-expanded='false'><i class='material-icons'>more_vert</i></a>");
            htmlBuilder.append("<div class='dropdown-menu dropdown-menu-right'>");
            htmlBuilder.append("<a class='dropdown-item update-btn' href='#' data-toggle='modal' data-target='#update_producto' data-id='").append(producto.getIdprod()).append("'>Editar</a>");
            htmlBuilder.append("<a class='dropdown-item delete-btn' href='/deleteProducto/").append(producto.getIdprod()).append("' data-toggle='modal' data-id='").append(producto.getIdprod()).append("'>Borrar</a>");
            htmlBuilder.append("</div></div></td></tr>");
        }
        return htmlBuilder.toString();
    }


}
