package cibertec.edu.pe.projectowebfinal.service;

import java.util.List;

import cibertec.edu.pe.projectowebfinal.model.OrdenCompra;

public interface OrdenCompraService {
List<OrdenCompra> getAllOrdenCompras();
	
	void saveOrden(OrdenCompra ordenCompra);
	
	OrdenCompra getOrdenById(String idorden);
	void deleteOrdenById(String idorden);


}
