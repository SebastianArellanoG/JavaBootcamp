import java.util.Scanner;

public class SoloPares {
 public static void main(String[] args) {
   Scanner scanner = new Scanner(System.in);
   System.out.println("Ingrese un numero positivo");
   int n = scanner.nextInt();

   for (int i = 0; i < n * 2; i++) {

     System.out.println(i);
     i = i + 1;
   }

  scanner.close();
 }
}