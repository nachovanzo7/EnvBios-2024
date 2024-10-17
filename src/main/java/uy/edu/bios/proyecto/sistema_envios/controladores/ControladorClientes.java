package uy.edu.bios.proyecto.sistema_envios.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import uy.edu.bios.proyecto.sistema_envios.dominio.Cliente;
import uy.edu.bios.proyecto.sistema_envios.excepciones.ExcepcionEnvios;
import uy.edu.bios.proyecto.sistema_envios.servicios.IServiciosClientes;

@Controller
@RequestMapping("/clientes")
public class ControladorClientes
{

    @Autowired
    private IServiciosClientes serviciosClientes;

    // Mostrar el perfil del cliente
    @GetMapping("/perfil")
    public String perfil(Model model, Authentication authentication)
    {
        Cliente cliente = serviciosClientes.obtener(authentication.getName());
        if (cliente == null) {
            model.addAttribute("mensaje", "¡ERROR! No se encontró el perfil del cliente.");
            return "error"; // Podrías tener una página de error genérica
        }
        model.addAttribute("cliente", cliente);
        return "clientes/perfil";
    }

    // Mostrar vista de "Confirmar eliminación"
    @GetMapping("/eliminar/confirmar")
    public String confirmarEliminacion(Authentication authentication, Model model)
    {
        String nombreUsuario = authentication.getName();
        Cliente cliente = serviciosClientes.obtener(nombreUsuario);

        if (cliente != null) {
            model.addAttribute("cliente", cliente);
            return "clientes/eliminar";  // Muestra la página de confirmación de eliminación
        } else {
            model.addAttribute("mensaje", "¡ERROR! No se encontró el cliente.");
            return "clientes/perfil";  // Redirige a perfil en caso de no encontrar cliente
        }
    }

    // POST --> Elimina al cliente
    @PostMapping("/eliminar")
    public String eliminarCuenta(Authentication authentication, RedirectAttributes attributes)
    {
        String nombreUsuario = authentication.getName();

        try 
        {
            serviciosClientes.eliminarCliente(nombreUsuario);
            attributes.addFlashAttribute("mensaje", "Cliente eliminado con éxito.");

            return "redirect:/";  

        } 

        catch (ExcepcionEnvios e) 
        {
            attributes.addFlashAttribute("mensaje", "¡ERROR! " + e.getMessage());
            return "redirect:/clientes/perfil";  
        }
    }

    // Muestro formulario para editar
    @GetMapping("/editar")
    public String mostrarEditar(Authentication authentication, Model model) 
    {
        Cliente cliente = serviciosClientes.obtener(authentication.getName());

        if (cliente != null) 
        {
            model.addAttribute("cliente", cliente);
            return "clientes/editar";
        } 

        else
        {
            model.addAttribute("mensaje", "ERROR--> Cliente no encontrado");
            return "redirect:/clientes/perfil";
        }
    }

    // POST --> Editar cliente
    @PostMapping("/editar")
    public String editarCliente(Authentication authentication, Cliente cliente, RedirectAttributes attributes)
    {
        String nomUsuario = authentication.getName();  // Usamos el nombre del usuario autenticado
        try 
        {
            serviciosClientes.editarCliente(nomUsuario, cliente);
            attributes.addFlashAttribute("mensaje", "Perfil actualizado con éxito");
            return "redirect:/clientes/editar";
        } 
        catch (ExcepcionEnvios e) 
        {
            attributes.addFlashAttribute("mensaje", "ERROR--> " + e.getMessage());
            return "redirect:/clientes/editar";
        }
    }
}
