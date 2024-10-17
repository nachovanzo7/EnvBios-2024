package uy.edu.bios.proyecto.sistema_envios.dominio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente extends Usuario
{
    @Column(nullable = false, unique = true)
    private String cedula;

    @Column(nullable = false)
    private String domicilio;

    @Column(nullable = false)
    private String telefono;

    private boolean activo;

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Cliente()
    {
        this(null, null, null, true);
    }

    public Cliente(String cedula, String domicilio, String telefono, boolean activo) {
        this.cedula = cedula;
        this.domicilio = domicilio; 
        this.telefono = telefono;
        this.activo = activo;
    }

    public Cliente(String nombreUsuario, String clave, String correoElectronico, String cedula, String domicilio,
            String telefono, boolean activo) {
        super(nombreUsuario, clave, correoElectronico);
        this.cedula = cedula;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.activo = activo;
    }

    

    
}
