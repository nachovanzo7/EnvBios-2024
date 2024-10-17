package uy.edu.bios.proyecto.sistema_envios.repositorios.especificaciones;

import org.springframework.data.jpa.domain.Specification;

import uy.edu.bios.proyecto.sistema_envios.dominio.Cliente;

public class EspecificacionesClientes 
{
    /*Especificacion para buscar cliente por nombre de usuario */
    public static Specification<Cliente> tieneNombreUsuario(String nombreUsuario) {
        return (root, query, criteriaBuilder) -> 
                criteriaBuilder.equal(root.get("nombreUsuario"), nombreUsuario);
    }

    /*Especificacion para buscar clientes (completo o parcial) */
    public static Specification<Cliente> tieneNombre(String nombre) {
        return (root, query, criteriaBuilder) -> 
                criteriaBuilder.like(root.get("nombre"), "%" + nombre + "%");
    }

    /*Especificacion para buscar clientes que están activos*/
    public static Specification<Cliente> estaActivo() {
        return (root, query, criteriaBuilder) -> 
                criteriaBuilder.isTrue(root.get("activo"));
    }

    /*Combinar ambas condiciones*/
    public static Specification<Cliente> buscar(String nombreUsuario, boolean activo) {
        return Specification
                .where((nombreUsuario != null && !nombreUsuario.isEmpty()) ? tieneNombreUsuario(nombreUsuario) : null)
                .and(activo ? estaActivo() : null);
    }

}
