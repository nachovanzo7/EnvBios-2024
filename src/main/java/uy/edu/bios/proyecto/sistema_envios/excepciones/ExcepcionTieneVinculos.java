package uy.edu.bios.proyecto.sistema_envios.excepciones;

public class ExcepcionTieneVinculos extends ExcepcionEnvios
{
    public ExcepcionTieneVinculos() {

    }

    public ExcepcionTieneVinculos(String mensaje) {
        super(mensaje);
    }

    public ExcepcionTieneVinculos(String mensaje, Exception excepcionInterna) {
        super(mensaje, excepcionInterna);
    }
}
