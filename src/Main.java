import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Vendedor vendedor = new Vendedor("123456", "Anakin Skywalker", 45, "Imperio");

        List<Cliente> clientes = List.of(
        new Cliente("444444", "Luke Skywalker", 19),
        new Cliente("555555", "Darth Vader", 45),
        new Cliente("666666", "Leia Organa", 23)
        );

        List<Vehiculo> vehiculos = List.of(
            new Taxi("Rojo", "A123456", 350),
            new Taxi("Verde", "A654321", 450),
            new MiniBus("Azul", "A111111", 6, "Vip"),
            new MiniBus("Amarillo", "A222222", 6, "Plebeyos"),
            new Bus("Negro", "A112233", 45),
            new Bus("Blanco", "A332211", 45)
        );

        Tienda tienda = new Tienda(vendedor, clientes, vehiculos.size(), vehiculos);

        List<LibroVenta> libroVentas = List.of(
            new LibroVenta("Organa", "20240517"),
            new LibroVenta("Vader", "20240505"),
            new LibroVenta("Skywalker", "20240515")
        );

        for (int i = 0; i < libroVentas.size(); i++) {
            libroVentas.get(i).guardarVenta(tienda.getCliente().get(i), tienda.getVehiculos().get(i));
        }

        printSeparator();
        System.out.println(tienda);
        printSeparator();
        System.out.println(libroVentas);
        printSeparator();

        for (Vehiculo vehiculo : vehiculos) {
            System.out.println(vehiculo);
        }

        printSeparator();



        LibroVenta prueba3 = new LibroVenta("VentaTrooper", "20240517");
        List<LibroVenta> lb1 = new ArrayList<>();
        lb1.add(prueba3);

        List<LibroVenta> lb2 = new ArrayList<>();
        lb2.add(prueba3);

        prueba3.setNombreVenta("Cualquier cosa");

        printSeparator();
        System.out.println(prueba3);
        System.out.println(lb1.get(0));
        System.out.println(lb2.get(0));
        printSeparator();
    }

    private static void printSeparator() {
        System.out.println("-----------------------------------------------");
    }
}
