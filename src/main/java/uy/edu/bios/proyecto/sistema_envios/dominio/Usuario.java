package uy.edu.bios.proyecto.sistema_envios.dominio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED  )
public class Usuario 
{
    @Id
    @Column(nullable = false, unique = true)
    private String nombreUsuario;

    @Column(nullable = false)
    private String clave;

    @Column(nullable = true, unique = false)
    private String correoElectronico;

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    

    public Usuario()
    {
        this(null, null, null);
    }

    public Usuario(String nombreUsuario, String clave, String correoElectronico) {
        this.nombreUsuario = nombreUsuario;
        this.clave = clave;
        this.correoElectronico = correoElectronico;
    }

    
}
