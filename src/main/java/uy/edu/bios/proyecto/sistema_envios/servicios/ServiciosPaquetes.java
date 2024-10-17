package uy.edu.bios.proyecto.sistema_envios.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uy.edu.bios.proyecto.sistema_envios.dominio.Paquete;
import uy.edu.bios.proyecto.sistema_envios.excepciones.ExcepcionEnvios;
import uy.edu.bios.proyecto.sistema_envios.excepciones.ExcepcionNoExiste;
import uy.edu.bios.proyecto.sistema_envios.repositorios.IRepositorioPaquete;

import java.util.List;
import java.util.Optional;

@Service
public class ServiciosPaquetes implements IServiciosPaquetes {

    @Autowired
    private IRepositorioPaquete repositorioPaquete;

    @Override
    public List<Paquete> buscarPaquetes(String direccionDestinatario) {
        if (direccionDestinatario == null || direccionDestinatario.isEmpty()) {
            return listarPaquetes(); // Retorna todos los paquetes si no hay búsqueda
        }
        return repositorioPaquete.findByDireccionDestinatarioContainingIgnoreCase(direccionDestinatario);
    }

    @Override
    public List<Paquete> listarPaquetes() {
        return repositorioPaquete.findAll();
    }

    @Override
    public Paquete obtenerPaquete(Long id) throws ExcepcionNoExiste {
        Optional<Paquete> paqueteOpt = repositorioPaquete.findById(id);
        if (paqueteOpt.isPresent()) {
            return paqueteOpt.get();
        }
        throw new ExcepcionNoExiste("El paquete no existe.");
    }

    @Override
    public void registrarPaquete(Paquete paquete) throws ExcepcionEnvios {
        repositorioPaquete.save(paquete);
    }

    @Override
    public Paquete editarPaquete(Long id, Paquete detallesPaquete) throws ExcepcionEnvios {
        Optional<Paquete> paqueteOpt = repositorioPaquete.findById(id);
        if (paqueteOpt.isPresent()) {
            Paquete paquete = paqueteOpt.get();
            paquete.setCliente(detallesPaquete.getCliente());
            paquete.setEmpleado(detallesPaquete.getEmpleado());
            paquete.setFechaRegistro(detallesPaquete.getFechaRegistro());
            paquete.setCategoria(detallesPaquete.getCategoria());
            paquete.setDireccionDestinatario(detallesPaquete.getDireccionDestinatario());
            paquete.setTelefonoDestinatario(detallesPaquete.getTelefonoDestinatario());
            paquete.setCobrarDestinatario(detallesPaquete.getCobrarDestinatario());
            paquete.setEstadoRastreo(detallesPaquete.getEstadoRastreo());
            return repositorioPaquete.save(paquete);
        }
        throw new ExcepcionNoExiste("El paquete no existe.");
    }

    @Override
    public void eliminarPaquete(Long id) throws ExcepcionNoExiste
    {
        Optional<Paquete> paqueteOpt = repositorioPaquete.findById(id);
        
        if (paqueteOpt.isPresent()) 
        {
            repositorioPaquete.delete(paqueteOpt.get());
        } 
        else 
        {
            throw new ExcepcionNoExiste("El paquete no existe.");
        }
    }
}
