package cl.praxis.services;
import cl.praxis.modelos.Cliente;
import java.util.ArrayList;
import java.util.List;


public class ServicioCliente {
    private static ServicioCliente instancia;
    private List<Cliente> listaClientes;

    private ServicioCliente() {
        listaClientes = new ArrayList<>();
    }

    public static synchronized ServicioCliente getInstancia() {
        if (instancia == null) {
            instancia = new ServicioCliente();
        }
        return instancia;
    }

    public void listarClientes() {
        if (listaClientes.isEmpty()) {
            System.out.println("No hay clientes");
            return;
        }
        listaClientes.forEach(cliente -> {
            System.out.println("--------------- Datos del Cliente ----------------");
            System.out.println("Run de Cliente: " + cliente.getRun());
            System.out.println("Nombre del Cliente: " + cliente.getNombre());
            System.out.println("Apellido del Cliente: " + cliente.getApellido());
            System.out.println("Años como Cliente: " + cliente.getAnios());
            System.out.println("Categoría del Cliente: " + cliente.getCategoria());
            System.out.println("-------------------------------------------------");
        });
    }

    public void agregarCliente(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("El cliente no puede ser nulo");
        }
        listaClientes.add(cliente);
    }

    public void editarCliente(int run, Cliente clienteModificado) {
        listaClientes.stream()
            .filter(cliente -> cliente.getRun() == run)
            .findFirst()
            .ifPresent(cliente -> {
                cliente.setRun(run);
                cliente.setNombre(clienteModificado.getNombre());
                cliente.setApellido(clienteModificado.getApellido());
                cliente.setAnios(clienteModificado.getAnios());
                cliente.setCategoria(clienteModificado.getCategoria());
            });
    }

    public List<Cliente> obtenerListaClientes() {
        return new ArrayList<>(listaClientes);
    }

    public Cliente getClienteByRun(int run) {
        return listaClientes.stream()
            .filter(cliente -> cliente.getRun() == run)
            .findFirst()
            .orElse(null);
    }
}
