package uy.edu.bios.proyecto.sistema_envios.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import uy.edu.bios.proyecto.sistema_envios.dominio.Paquete;
import uy.edu.bios.proyecto.sistema_envios.excepciones.ExcepcionEnvios;
import uy.edu.bios.proyecto.sistema_envios.excepciones.ExcepcionNoExiste;
import uy.edu.bios.proyecto.sistema_envios.servicios.IServiciosPaquetes;

import java.util.List;

@RestController
@RequestMapping("/paquetes")
public class ControladorPaquetes 
{

    @Autowired
    private IServiciosPaquetes serviciosPaquetes;

    @GetMapping
    public List<Paquete> listarPaquetes(@RequestParam(required = false) String direccionDestinatario) {
        return serviciosPaquetes.buscarPaquetes(direccionDestinatario);
    }

    @GetMapping("/{id}")
    public Paquete obtenerPaquete(@PathVariable Long id) throws ExcepcionNoExiste {
        return serviciosPaquetes.obtenerPaquete(id);
    }

    @PostMapping
    public Paquete registrarPaquete(@RequestBody Paquete paquete) {
        try {
            serviciosPaquetes.registrarPaquete(paquete);
            return paquete;  // Devolver el paquete registrado
        } catch (ExcepcionEnvios e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public Paquete editarPaquete(@PathVariable Long id, @RequestBody Paquete detallesPaquete) {
        try {
            return serviciosPaquetes.editarPaquete(id, detallesPaquete);
        } catch (ExcepcionNoExiste e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        } catch (ExcepcionEnvios e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void eliminarPaquete(@PathVariable Long id) {
        try {
            serviciosPaquetes.eliminarPaquete(id);
        } catch (ExcepcionNoExiste e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}
