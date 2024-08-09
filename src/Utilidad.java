import java.util.Scanner;

public class Utilidad {

    public static void limpiarPantalla() {

        System.out.flush();
    }

    public static void tiempoEspera(long seg) {
        try {
            Thread.sleep(seg * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static int inputInt(String msge) {
        try (Scanner sc = new Scanner(System.in)) {
            int num = 0;
            boolean valid = false;

            do {
                System.out.println(msge);
                if (sc.hasNextInt()) {
                    num = sc.nextInt();
                    valid = true;
                } else {
                    System.out.println("Ingrese un Valor Valido (int)");
                    sc.nextLine(); // Clear the invalid input
                }
            } while (!valid);

            return num;
        }
    }

    public static String inputStr(String msge) {
        try (Scanner sc = new Scanner(System.in)) {
            String str = "";

            do {
                System.out.println(msge);
                if (sc.hasNextInt()) {
                    System.out.println("Ingrese un Valor Valido (str)");
                    sc.nextLine(); // Clear the invalid input
                } else {
                    str = sc.nextLine();
                }
            } while (str.isEmpty());

            return str;
        }
    }
}
