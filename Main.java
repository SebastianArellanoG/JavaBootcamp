import java.util.*;


public class Main {
    public static void main(String[] args) {
        ejercicio1();
        ejercicio2();
        ejercicio3();
        ejercicio4();
    }

    private static void ejercicio1() {

        List<String> marcas = new ArrayList<String>();


        marcas.add("Sony");
        marcas.add("Adidas");
        marcas.add("PepsiCo");
        marcas.add("LG");
        marcas.add("Honda");
        marcas.add("IBM");
        marcas.add("Facebook");
        marcas.add("Alibaba");
        marcas.add("Nestle");
        marcas.add("Burger King");
        System.out.println(marcas);

        System.out.println(" 3. Marcas-");
        marcas.add("Blokbaster");
        marcas.add("Carrefour");
        marcas.add("Jetix");
        System.out.println(marcas);

        System.out.println(" 4. ");
        marcas.set(10, "Blockbuster");
        System.out.println(marcas);

        System.out.println("5. ");
        String remover = "Carrefour";
        System.out.println("Remover: " + remover + " = " + marcas.remove(remover));
        System.out.println(marcas);

        System.out.println(" 6. ");
        List<String> posiblesMarcas = new ArrayList<>();
        posiblesMarcas.add("Nokia");
        posiblesMarcas.add("BlackBerry");
        posiblesMarcas.add("Sears");
        marcas.addAll(posiblesMarcas);
        System.out.println(marcas);

        System.out.println("-7. ");
        System.out.println("La lista tiene (" + marcas.size() + ") elementos");


    }

    private static void ejercicio2() {
        System.out.println(" 1. ");
        Set<String> invitados = new TreeSet<>();

        System.out.println(" 2. ");
        invitados.add("Daniel");
        invitados.add("Paola");
        invitados.add("Facundo");
        invitados.add("Pedro");
        invitados.add("Jacinta");
        invitados.add("Florencia");
        invitados.add("Juan Pablo");
        System.out.println(invitados);

        System.out.println(" 3. ");
        invitados.add("Jorge");
        invitados.add("Francisco");
        invitados.add("Marcos");
        System.out.println(invitados);

        System.out.println(" 4. ");
        invitados.remove("Jorge");
        System.out.println(invitados);
    }

    private static void ejercicio3() {
        System.out.println(" 1. ");
        Map<String, Integer> golosinas = new TreeMap<>();

        System.out.println(" 2. ");
        golosinas.put("Chocman", 100);
        golosinas.put("Trululú", 100);
        golosinas.put("Centella", 100);
        golosinas.put("Kilate", 50);
        golosinas.put("Miti-miti", 30);
        golosinas.put("Traga Traga", 150);
        golosinas.put("Tabletón", 5);

        System.out.println(" 3. ");
        Integer filtrar = 100;
        for(Map.Entry<String, Integer> golosina : golosinas.entrySet()) {
            if(golosina.getValue() < filtrar) {
                System.out.println(golosina.getKey());
            }
        }
    }

    private static void ejercicio4() {
        System.out.println(" 1. ");
        Queue<String> juegos = new LinkedList<>();

        System.out.println(" 2. ");
        juegos.add("Tombo");
        juegos.add("Congelado");
        juegos.add("Quemaditas");
        juegos.add("Cachipún");
        juegos.add("Pillarse");

        System.out.println(" 3. ");
        System.out.println("Cantidad de juegos: " + juegos.size()) ;
    }
}