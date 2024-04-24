import java.util.Scanner;

public class SumaImparLimite {
 public static void main(String[] args) {
   Scanner scanner = new Scanner(System.in);
   System.out.println("Ingrese limite inferior positivo");
   int min = scanner.nextInt();  // change here
   System.out.println("Ingrese limite superior positivo");
   int max = scanner.nextInt();  // change here
   int sum = 0;

   for (int i = min; i <= max ; i++) {
     if (i % 2 != 0){
       sum += i;
     }
   }
   System.out.println("The sum is: " + sum);
   scanner.close();
 }
}