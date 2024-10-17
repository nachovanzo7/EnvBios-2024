package uy.edu.bios.proyecto.sistema_envios.servicios;

import uy.edu.bios.proyecto.sistema_envios.dominio.Paquete;
import uy.edu.bios.proyecto.sistema_envios.excepciones.ExcepcionEnvios;
import uy.edu.bios.proyecto.sistema_envios.excepciones.ExcepcionNoExiste;

import java.util.List;

public interface IServiciosPaquetes {
    List<Paquete> buscarPaquetes(String direccionDestinatario);
    List<Paquete> listarPaquetes();
    Paquete obtenerPaquete(Long id) throws ExcepcionNoExiste;
    void registrarPaquete(Paquete paquete) throws ExcepcionEnvios;
    Paquete editarPaquete(Long id, Paquete detallesPaquete) throws ExcepcionEnvios;
    void eliminarPaquete(Long id) throws ExcepcionNoExiste;
}
