package uy.edu.bios.proyecto.sistema_envios.dominio;

public class EstadoDeRastreo 
{
    private Long id;

    private String descripcion;

    private boolean activo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public EstadoDeRastreo()
    {
        this(null, null, true);
    }

    public EstadoDeRastreo(Long id, String descripcion, boolean activo) {
        this.id = id;
        this.descripcion = descripcion;
        this.activo = activo;
    }


    
}
