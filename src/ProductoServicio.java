import java.util.ArrayList;
import java.util.List;

public class ProductoServicio {
    private static ProductoServicio instance;
    private List<Producto> listaProductos;

    private ProductoServicio() {
        listaProductos = new ArrayList<>();
    }

    public static ProductoServicio getInstance() {
        if (instance == null) {
            instance = new ProductoServicio();
        }
        return instance;
    }

    public void listarProductos() {
        if (listaProductos.isEmpty()) {
            System.out.println("No se encontraron ningun producto:");
        } else {
            for (Producto p : listaProductos) {
                System.out.println(" Datos del Producto ");
                System.out.println("Nombre articulo: " + p.getArticulo());
                System.out.println("Código: " + p.getCodigo());
                System.out.println("Marca: " + p.getMarca());
                System.out.println("Color: " + p.getColor());
                System.out.println("Descripcion: " + p.getDescripcion());
                System.out.println("Precio: " + p.getPrecio());
                System.out.println("Talla: " + p.getTalla());
                System.out.println("----------");
            }
        }
    }

    public void agregarProducto(Producto producto) {
        listaProductos.add(producto);
    }

    public Producto obtenerProducto(int codigo) {
        return listaProductos.stream()
                             .filter(p -> p.getCodigo() == codigo)
                             .findFirst()
                             .orElse(null);
    }

    public void modificarProducto(int codigo, Producto producto) {
        for (int i = 0; i < listaProductos.size(); i++) {
            if (listaProductos.get(i).getCodigo() == codigo) {
                listaProductos.set(i, producto);
                break;
            }
        }
    }

    public List<Producto> getListaProductos() {
        return new ArrayList<>(listaProductos);
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = new ArrayList<>(listaProductos);
    }
}
