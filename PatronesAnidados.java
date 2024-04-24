import java.util.Scanner;

public class PatronesAnidados {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese un número n para determinar el tamaño de los patrones: ");
        int n = scanner.nextInt();
        scanner.close();

        dibujarPatron1(n);
        dibujarPatron2(n);
        dibujarPatron3(n);
        dibujarPatron4(n);
    }

    private static void dibujarPatron1(int n) {
        System.out.println("Patrón 1:");
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(i == 0 || i == n-1 || j == 0 || j == n-1)
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }
            System.out.println();
        }
    }

    private static void dibujarPatron2(int n) {
        System.out.println("\nPatrón 2:");
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
              if (i == 0 || i == n - 1 || j == n - i - 1 )
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }
            System.out.println();
        }
    }

    private static void dibujarPatron3(int n) {
        System.out.println("\nPatrón 3:");
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(i == j || i + j == n - 1)
                    System.out.print("x ");
                else
                    System.out.print("  ");
            }
            System.out.println();
        }
    }

    private static void dibujarPatron4(int n) {
        System.out.println("\nPatrón 4:");
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if( i == 0 && j!= n - 1 ||  i != 0 && j!= n - 1 && j != 0 || i==0 && j == 0 || i == n - 1 && j == n-1)
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }
            System.out.println();
        }
    }
}