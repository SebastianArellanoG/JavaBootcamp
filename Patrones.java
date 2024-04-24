import java.util.Scanner;

public class Patrones {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese un número para determinar cuántos caracteres se deben mostrar: ");
        int n = scanner.nextInt();

        scanner.close();

        String patron1 = "*.";
        String patron2 = "1234";
        String patron3 = "||*";

        System.out.println(crearPatron(patron1, n));
        System.out.println(crearPatron(patron2, n));
        System.out.println(crearPatron(patron3, n));
    }

    private static String crearPatron(String patron, int longitud) {
        StringBuilder stringBuilder = new StringBuilder();
        while (stringBuilder.length() < longitud) {
            stringBuilder.append(patron);
        }
        return stringBuilder.substring(0, longitud);
    }
}