package cibertec.edu.pe.projectowebfinal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotEmpty;
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
	    @NotEmpty
	    private String nombre;
	    @Column(name ="direccion")
	    @NotEmpty
	    private String direccion;
	    @Column(name ="telefono")
	    @NotEmpty
	    private String telefono;
	    @Column(name ="ruc")
	    @NotEmpty
	    private String ruc;
	    @Column(name ="razonsocial")
	    @NotEmpty
	    private String razonsocial;
	    @Column(name ="pais")
	    @NotEmpty
	    private String pais;
	    @Column(name ="ciudad")
	    @NotEmpty
	    private String ciudad;
}
