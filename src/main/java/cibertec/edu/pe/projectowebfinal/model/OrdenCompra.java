package cibertec.edu.pe.projectowebfinal.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
	@Column(name="fecha")
	private Date fecha;
	@ManyToOne
	@JoinColumn(name="idprov")
	private Proveedor proveedor;
	//@JoinColumn(name="idusu")
	//private Usuario usuario;
}
