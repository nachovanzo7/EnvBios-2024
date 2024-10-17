package uy.edu.bios.proyecto.sistema_envios.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uy.edu.bios.proyecto.sistema_envios.dominio.Paquete;

import java.util.List;

@Repository
public interface IRepositorioPaquete extends JpaRepository<Paquete, Long> {
    List<Paquete> findByDireccionDestinatarioContainingIgnoreCase(String direccionDestinatario);
}
