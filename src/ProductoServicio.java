import java.util.ArrayList;
import java.util.List;

public class ProductoServicio {
    private static ProductoServicio instancia;
    private List<Producto> listaProductos;

    private ProductoServicio() {
        this.listaProductos = new ArrayList<>();
    }

    public static synchronized ProductoServicio getInstance() {
        if (instancia == null) {
            instancia = new ProductoServicio();
        }
        return instancia;
    }

    public void listarProductos() {
        listaProductos.forEach(System.out::println);
    }

    public void agregarProducto(Producto producto) {
        listaProductos.add(producto);
    }

    public List<Producto> getListaProductos() {
        return new ArrayList<>(listaProductos);
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = new ArrayList<>(listaProductos);
    }
}
