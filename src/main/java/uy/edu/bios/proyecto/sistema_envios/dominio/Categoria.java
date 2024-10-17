package uy.edu.bios.proyecto.sistema_envios.dominio;

public class Categoria 
{
    private Long id;

    private String nombre;

    private boolean activo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Categoria()
    {
        this(null, null, true);
    }

    public Categoria(Long id, String nombre, boolean activo) {
        this.id = id;
        this.nombre = nombre;
    }
    
}
