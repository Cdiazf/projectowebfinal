package cibertec.edu.pe.projectowebfinal.request;

public class ConsultaProductosRequest {
    private String descripcion;
    private String idTipo;
    private Integer estado;

    public ConsultaProductosRequest() {
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(String idTipo) {
        this.idTipo = idTipo;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
}

