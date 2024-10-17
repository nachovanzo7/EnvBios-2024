package uy.edu.bios.proyecto.sistema_envios.dominio;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Paquete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "empleado_id")
    private Empleado empleado;

    private LocalDateTime fechaRegistro;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    private String direccionDestinatario;
    private String telefonoDestinatario;
    private Boolean cobrarDestinatario;

    @ManyToOne
    @JoinColumn(name = "estado_rastreo_id")
    private EstadoDeRastreo estadoRastreo;

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getDireccionDestinatario() {
        return direccionDestinatario;
    }

    public void setDireccionDestinatario(String direccionDestinatario) {
        this.direccionDestinatario = direccionDestinatario;
    }

    public String getTelefonoDestinatario() {
        return telefonoDestinatario;
    }

    public void setTelefonoDestinatario(String telefonoDestinatario) {
        this.telefonoDestinatario = telefonoDestinatario;
    }

    public Boolean getCobrarDestinatario() {
        return cobrarDestinatario;
    }

    public void setCobrarDestinatario(Boolean cobrarDestinatario) {
        this.cobrarDestinatario = cobrarDestinatario;
    }

    public EstadoDeRastreo getEstadoRastreo() {
        return estadoRastreo;
    }

    public void setEstadoRastreo(EstadoDeRastreo estadoRastreo) {
        this.estadoRastreo = estadoRastreo;
    }

    // Constructores
    public Paquete() {
        // Constructor vacío
    }

    public Paquete(Long id, Cliente cliente, Empleado empleado, LocalDateTime fechaRegistro, Categoria categoria,
                   String direccionDestinatario, String telefonoDestinatario, Boolean cobrarDestinatario,
                   EstadoDeRastreo estadoRastreo) {
        this.id = id;
        this.cliente = cliente;
        this.empleado = empleado;
        this.fechaRegistro = fechaRegistro;
        this.categoria = categoria;
        this.direccionDestinatario = direccionDestinatario;
        this.telefonoDestinatario = telefonoDestinatario;
        this.cobrarDestinatario = cobrarDestinatario;
        this.estadoRastreo = estadoRastreo;
    }
}
