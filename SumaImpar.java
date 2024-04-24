import java.util.Scanner;

public class SumaImpar {
 public static void main(String[] args) {
   Scanner scanner = new Scanner(System.in);
   System.out.println("Ingrese un numero positivo");
   int n = scanner.nextInt();
   int sum = 0;

   for (int i = 0; i <= n ; i++) {

     if (i % 2 != 0){
       sum += i;
   }
   }
    System.out.println("The sum is: " + sum);
  scanner.close();
 }
}