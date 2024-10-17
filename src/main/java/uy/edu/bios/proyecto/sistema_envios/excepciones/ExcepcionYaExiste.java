package uy.edu.bios.proyecto.sistema_envios.excepciones;

public class ExcepcionYaExiste extends ExcepcionEnvios
{
    public ExcepcionYaExiste() {

    }

    public ExcepcionYaExiste(String mensaje) {
        super(mensaje);
    }

    public ExcepcionYaExiste(String mensaje, Exception excepcionInterna) {
        super(mensaje, excepcionInterna);
    }
}
