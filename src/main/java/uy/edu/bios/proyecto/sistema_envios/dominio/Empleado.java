package uy.edu.bios.proyecto.sistema_envios.dominio;

public class Empleado extends Usuario
{
    private Sucursal sucursal;

    private boolean activo;

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Empleado()
    {
        this(null, true);
    }

    public Empleado(Sucursal sucursal, boolean activo) {
        this.sucursal = sucursal;
        this.activo = activo;
    }

    public Empleado(String nombreUsuario, String clave, String correoElectronico, Sucursal sucursal, boolean activo) {
        super(nombreUsuario, clave, correoElectronico);
        this.sucursal = sucursal;
        this.activo = activo;
    }

    

}
