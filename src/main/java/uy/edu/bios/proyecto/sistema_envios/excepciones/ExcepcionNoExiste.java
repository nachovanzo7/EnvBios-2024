package uy.edu.bios.proyecto.sistema_envios.excepciones;

public class ExcepcionNoExiste extends ExcepcionEnvios
{
    public ExcepcionNoExiste() {

    }

    public ExcepcionNoExiste(String mensaje) {
        super(mensaje);
    }

    public ExcepcionNoExiste(String mensaje, Exception excepcionInterna) {
        super(mensaje, excepcionInterna);
    }

}
