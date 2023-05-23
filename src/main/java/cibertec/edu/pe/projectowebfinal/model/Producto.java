package cibertec.edu.pe.projectowebfinal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "tb_productos")
public class Producto {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private String idprod;
    @Column(name ="descripcion")
    private String descripcion;
    @Column(name ="stock")
    private int stock;
    @Column(name ="precio")
    private double precio;
    @ManyToOne
    @JoinColumn(name = "idtipo")
    private Categorias categoria;
    @Column(name ="estado")
    private int estado;


}
