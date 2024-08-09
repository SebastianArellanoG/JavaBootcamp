import java.util.List;
import java.util.Scanner;

public class Menu {
    private final List<String> opciones;

    public Menu() {
        opciones = List.of(
            "1. Listar Producto",
            "2. Agregar Producto",
            "3. Exportar Datos",
            "4. Salir"
        );
        mostrarOpciones();
    }

    private void mostrarMenu() {
        System.out.println("--------------------- Menu ----------------------");
        opciones.forEach(System.out::println);
        System.out.println("-------------------------------------------------");
    }

    public void mostrarOpciones() {
        int opcion;
        mostrarMenu();

        do {
            opcion = inputInt("Ingrese una Opcion:");

            switch (opcion) {
                case 1 -> listarProducto();
                case 2 -> agregarProducto();
                case 3 -> exportarProducto();
                case 4 -> System.out.println("Saliendo...");
                default -> System.out.println("Ingrese una Opcion Valida (Menu)");
            }

            if (opcion >= 1 && opcion <= 3) {
                mostrarMenu();
            }
        } while (opcion != 4);
    }

    private void listarProducto() {
        System.out.println("------------- Listar Producto -------------------");
        ProductoServicio.getInstance().listarProductos();
    }

    private void agregarProducto() {
        System.out.println("------------- Agregar Producto ------------------");
        String articulo = inputStr("Ingresar nombre articulo:");
        int precio = inputInt("Ingresar precio:");
        String descripcion = inputStr("Ingresar descripción:");
        int codigo = inputInt("Ingresar código:");
        String talla = inputStr("Ingresar talla:");
        String marca = inputStr("Ingresar marca:");
        String color = inputStr("Ingresar color:");
        System.out.println("--------------- Producto Agregado ---------------");

        Producto producto = new Producto(articulo, precio, descripcion, codigo, talla, marca, color);
        ProductoServicio.getInstance().agregarProducto(producto);
    }

    private void exportarProducto() {
        new ExportadorTxt().exportar();
    }

    private int inputInt(String mensaje) {
        try (Scanner sc = new Scanner(System.in)) {
            int num = 0;

            while (num == 0) {
                System.out.println(mensaje);
                if (sc.hasNextInt()) {
                    num = sc.nextInt();
                } else {
                    System.out.println("Ingrese un Valor Valido (int)");
                    sc.nextLine();
                }
            }

            return num;
        }
    }

    private String inputStr(String mensaje) {
        try (Scanner sc = new Scanner(System.in)) {
            String str = "";

            while (str.isEmpty()) {
                System.out.println(mensaje);
                if (sc.hasNextInt()) {
                    System.out.println("Ingrese un Valor Valido (str)");
                    sc.nextLine();
                } else {
                    str = sc.nextLine();
                }
            }

            return str;
        }
    }
}
