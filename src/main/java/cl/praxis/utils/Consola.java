package cl.praxis.utils;

import java.util.Scanner;

public class Consola {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static int inputInt(String message) {
        int number;
        while (true) {
            System.out.println(message);
            if (SCANNER.hasNextInt()) {
                number = SCANNER.nextInt();
                SCANNER.nextLine(); // Clear the buffer
                break;
            } else {
                System.out.println("Ingrese un Valor Valido (int)");
                SCANNER.next(); // Clear the invalid input
            }
        }
        return number;
    }

    public static String inputStr(String message) {
        String input;
        while (true) {
            System.out.println(message);
            input = SCANNER.nextLine();
            if (!input.isEmpty()) {
                break;
            } else {
                System.out.println("Ingrese un Valor Valido (str)");
            }
        }
        return input;
    }

    public static void delay(long seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public static void limpiarConsola() {

        System.out.flush();
    }
}
