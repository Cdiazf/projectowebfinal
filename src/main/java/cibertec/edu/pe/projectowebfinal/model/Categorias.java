package cibertec.edu.pe.projectowebfinal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "tb_categorias")
public class Categorias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idtipo;

    @Column(name ="nombrecategoria")
    private String nombrecategoria;



}
