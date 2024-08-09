
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Vendedor vendedor = new Vendedor("123456", "Anakin Skywalker", 45, "Imperio");

        List<Cliente> clientes = List.of(
            new Cliente("111111", "Storm Trooper", 25),
            new Cliente("222222", "Jabba de Hutt", 265),
            new Cliente("333333", "Boba Fett", 62)
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

        System.out.println("_____");
        System.out.println(tienda);
        System.out.println("___");
    }
}
