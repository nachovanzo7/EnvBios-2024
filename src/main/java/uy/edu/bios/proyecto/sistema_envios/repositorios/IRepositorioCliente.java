package uy.edu.bios.proyecto.sistema_envios.repositorios;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import uy.edu.bios.proyecto.sistema_envios.dominio.Cliente;
import java.util.List;
import java.util.Optional;


@Repository
public interface IRepositorioCliente extends JpaRepository<Cliente, String>, JpaSpecificationExecutor<Cliente> 
{
    Optional<Cliente> findByNombreUsuario(String nombreUsuario);

    List<Cliente> findByActivoTrue();
    
    List<Cliente> findByActivoFalse();
}
