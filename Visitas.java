public class Visitas {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No se proporcionaron datos de visitas");
            return;
        }

        int[] visitas = new int[args.length];

        for (int i = 0; i < args.length; i++) {
            visitas[i] = Integer.parseInt(args[i]);
        }

        System.out.println(promedio(visitas));
    }

    public static int promedio(int[] visitas) {
        int sum = 0;
        for (int i = 0; i < visitas.length; i++) {
            sum += visitas[i];
        }

        return sum / visitas.length;
    }

}