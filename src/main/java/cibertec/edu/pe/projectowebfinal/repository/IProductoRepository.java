package cibertec.edu.pe.projectowebfinal.repository;

import cibertec.edu.pe.projectowebfinal.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoRepository extends JpaRepository<Producto,String> {
}
