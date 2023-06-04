package cibertec.edu.pe.projectowebfinal.model;
import java.sql.Date;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tb_ordenes_de_compra")
public class OrdenCompra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String idorden;
	@Column(name="descripcion")
	private String descripcion;
	@Column(name="fecha")
	private Date fecha;
	@Column(name="total")
	private Double total;

	@ManyToOne
	@JoinColumn(name="idprov")
	private Proveedor proveedor;

	@ManyToOne
	@JoinColumn(name="email")
	private User user;


}
