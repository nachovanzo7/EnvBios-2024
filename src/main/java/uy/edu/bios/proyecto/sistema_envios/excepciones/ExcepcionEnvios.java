package uy.edu.bios.proyecto.sistema_envios.excepciones;

public class ExcepcionEnvios extends Exception
{
    public ExcepcionEnvios() {

    }

    public ExcepcionEnvios(String mensaje) {
        super(mensaje);
    }

    public ExcepcionEnvios(String mensaje, Exception excepcionInterna) {
        super(mensaje, excepcionInterna);
    }
}
