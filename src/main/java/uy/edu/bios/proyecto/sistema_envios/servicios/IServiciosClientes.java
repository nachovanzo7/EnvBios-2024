package uy.edu.bios.proyecto.sistema_envios.servicios;

import java.util.List;

import uy.edu.bios.proyecto.sistema_envios.dominio.Cliente;
import uy.edu.bios.proyecto.sistema_envios.excepciones.ExcepcionEnvios;

public interface IServiciosClientes 
{
     public void registrarCliente(Cliente cliente) throws ExcepcionEnvios;
     public Cliente editarCliente(String nomUsuario, Cliente clienteDetalles) throws ExcepcionEnvios;
     public void eliminarClienteLogico(String nomUsuario) throws ExcepcionEnvios;
     public void eliminarCliente(String nomUsuario) throws ExcepcionEnvios;
     public List<Cliente> listarClientes();
     public Cliente obtener(String nombreUsuario);
     public List<Cliente> buscar(String nombreUsuario, boolean activo);

}
