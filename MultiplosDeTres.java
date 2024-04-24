public class MultiplosDeTres {
    public static void main(String[] args) {
        int[] numbers = new int[args.length];
        for (int i=0; i<args.length; i++) {
            numbers[i] = Integer.parseInt(args[i]);
        }
        System.out.println(suma(numbers));
    }

    public static int suma(int[] numbers) {
        int sum = 0;
        for (int number: numbers) {
            if (number % 3 == 0) {
                sum += number;
            }
        }
        return sum;
    }
}