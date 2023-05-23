package cibertec.edu.pe.projectowebfinal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "tb_proveedores")
public class Proveedor {
		@Id
		@GeneratedValue(strategy =  GenerationType.IDENTITY)
		private String idprov;
	    @Column(name ="nombre")
	    private String nombre;
	    @Column(name ="direccion")
	    private String direccion;
	    @Column(name ="telefono")
	    private String telefono;
}
