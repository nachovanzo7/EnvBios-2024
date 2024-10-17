package uy.edu.bios.proyecto.sistema_envios.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import uy.edu.bios.proyecto.sistema_envios.dominio.Cliente;
import uy.edu.bios.proyecto.sistema_envios.dominio.Usuario;
import uy.edu.bios.proyecto.sistema_envios.excepciones.ExcepcionEnvios;
import uy.edu.bios.proyecto.sistema_envios.repositorios.IRepositorioCliente;
import uy.edu.bios.proyecto.sistema_envios.repositorios.especificaciones.EspecificacionesClientes;
import uy.edu.bios.proyecto.sistema_envios.excepciones.ExcepcionNoExiste;
import uy.edu.bios.proyecto.sistema_envios.excepciones.ExcepcionYaExiste;

@Service
public class ServiciosClientes implements IServiciosClientes
{
    @Autowired
    private IRepositorioCliente repositorioCliente;

    @Override
    public List<Cliente> buscar(String nombreUsuario, boolean activo)
    {
        Specification<Cliente> especificacion = EspecificacionesClientes.buscar(nombreUsuario, activo);
    return repositorioCliente.findAll(especificacion);
    }

    @Override
    public Cliente obtener(String nombreUsuario) {
        return repositorioCliente.findById(nombreUsuario).orElse(null);
    }

    @Override
    public void registrarCliente(Cliente cliente) throws ExcepcionEnvios
    {
        cliente.setActivo(true);

        Usuario usuarioExistente = repositorioCliente.findById(cliente.getNombreUsuario()).orElse(null);

        if (usuarioExistente != null) {
            throw new ExcepcionYaExiste("El usuario ya existe.");
        }

        repositorioCliente.save(cliente);
    }

    @Override
    public Cliente editarCliente(String nomUsuario, Cliente clienteDetalles) throws ExcepcionEnvios
    {
        Optional<Cliente> clienteOpt = repositorioCliente.findById(nomUsuario);

        if (clienteOpt.isPresent())
        {
            Cliente cliente = clienteOpt.get();

            if (clienteDetalles.getCorreoElectronico() != null) {
                cliente.setCorreoElectronico(clienteDetalles.getCorreoElectronico());
            }
            if (clienteDetalles.getCedula() != null) {
                cliente.setCedula(clienteDetalles.getCedula());
            }
            if (clienteDetalles.getDomicilio() != null) {
                cliente.setDomicilio(clienteDetalles.getDomicilio());
            }
            if (clienteDetalles.getTelefono() != null) {
                cliente.setTelefono(clienteDetalles.getTelefono());
            }

            return repositorioCliente.save(cliente);
        }
        else
            throw new ExcepcionNoExiste("El cliente " + nomUsuario + " no existe");
    }

    @Override
    public void eliminarClienteLogico(String nomUsuario) throws ExcepcionEnvios
    {
        Optional<Cliente> clienteOpt = repositorioCliente.findById(nomUsuario);

        if (clienteOpt.isPresent())
        {
            Cliente cliente = clienteOpt.get();
            cliente.setActivo(false);
            repositorioCliente.save(cliente);
        }
    }

    @Override
    public void eliminarCliente(String nomUsuario) throws ExcepcionEnvios
    {
        Cliente clienteExistente = repositorioCliente.findById(nomUsuario).orElse(null);

        if (clienteExistente == null) {
            throw new ExcepcionNoExiste("El cliente no existe.");
        }

        repositorioCliente.deleteById(nomUsuario);
    }

    @Override
    public List<Cliente> listarClientes()
    {
        return new ArrayList<>(repositorioCliente.findAll());
    }

}
