public class Promedios {
  public static void main(String[] args) {
      if (args.length == 0) {
            System.out.println("No se proporcionaron datos de visitas");
            return;
        }
        int[] numbers = new int[args.length];
        for (int i=0; i<args.length; i++) {
            numbers[i] = Integer.parseInt(args[i]);
        }
       suma(numbers);
    }

    public static int suma(int[] numbers) {
      int sum = 0;
      int counter = 0;
      for (int number : numbers) {
        if (number % 3 == 0) {
          sum += number;
          counter++;
        }
      }
      System.out.println(sum);
      System.out.println(sum/counter);
      return sum;

    }
}