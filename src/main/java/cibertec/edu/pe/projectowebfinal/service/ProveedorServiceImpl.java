package cibertec.edu.pe.projectowebfinal.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cibertec.edu.pe.projectowebfinal.model.Producto;
import cibertec.edu.pe.projectowebfinal.model.Proveedor;
import cibertec.edu.pe.projectowebfinal.repository.IProveedorRepository;

@Service
public class ProveedorServiceImpl implements ProveedorService {

	@Autowired
	private IProveedorRepository proveedorRepository;
	
	@Override
	public List<Proveedor> getAllProveedores() {		
		return proveedorRepository.findAll();
	}

	@Override
	public void saveProveedor(Proveedor proveedor) {
		this.proveedorRepository.save(proveedor);		
	}

	@Override
    public Proveedor getProveedorById(String idprov) {
        Optional<Proveedor> optional=proveedorRepository.findById(idprov);
        Proveedor proveedor=null;
        if(optional.isPresent()){
            proveedor=optional.get();
        }else{
            throw new RuntimeException("Proveedor no encontrado con el ID::"+idprov);
        }
        return proveedor;
    }

	@Override
	public void deleteProveedorById(String idprov) {
	this.proveedorRepository.deleteById(idprov);
		
	}

	
	 @Override
	    public List<Proveedor> consultarProveedorPorNombre(String nombre) {
	        List<Proveedor> proveedoresConsultados = new ArrayList<>();

	        // consultar producto por descripcion
	        for (Proveedor proveedor: getAllProveedores()){
	            if (proveedor.getIdprov().toLowerCase().contains(nombre.toLowerCase())){
	            	proveedoresConsultados.add(proveedor);
	            }
	        }
	        return proveedoresConsultados;
	    }

	    @Override
	    public List<Proveedor> consultarProveedorPorIdProv(Long idProv) {
	        return null;
	    }


	

	
	

}
