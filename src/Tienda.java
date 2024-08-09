import java.util.List;

public class Tienda {
    private Vendedor vendedor;
    private List<Cliente> clientes;
    private int stock;
    private List<Vehiculo> vehiculos;

    public Tienda() {}

    public Tienda(Vendedor vendedor, List<Cliente> clientes, int stock, List<Vehiculo> vehiculos) {
        this.vendedor = vendedor;
        this.clientes = clientes;
        this.stock = stock;
        this.vehiculos = vehiculos;
    }

    public String existeStock() {
        return String.format("Cantidad de Stock es: %d", this.stock);
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    @Override
    public String toString() {
        return String.format("Tienda{vendedor=%s, clientes=%s, stock=%d, vehiculos=%s}",
                              vendedor, clientes, stock, vehiculos);
    }
}
