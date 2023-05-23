package cibertec.edu.pe.projectowebfinal.service;

import java.util.List;

import cibertec.edu.pe.projectowebfinal.model.Proveedor;
public interface ProveedorService {

	List<Proveedor> getAllProveedores();
	
	void saveProveedor(Proveedor proveedor);
	
	void deleteProveedorById(String idprov);
		 
	
	 List<Proveedor> consultarProveedorPorNombre(String consulta);

	 List<Proveedor> consultarProveedorPorIdProv(Long idProv);

	Proveedor getProveedorById(String idprov);


	



	
}
