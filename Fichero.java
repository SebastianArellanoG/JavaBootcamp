import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fichero {
    private static final String RUTA = "src" + File.separator + "cl" + File.separator + "praxis" + File.separator + "curso" + File.separator + "m4" + File.separator + "desafio_m4_dia18" + File.separator;

    public static void main(String[] args) {
        String directorio = inputStr("Ingrese Nombre del Directorio");
        String archivo = inputStr("Ingrese Nombre del Archivo");
        String texto = inputStr("Ingrese Texto a Buscar");

        directorio = RUTA + directorio;
        archivo = archivo + ".txt";

        crearArchivo(directorio, archivo);
        buscarTexto(directorio + File.separator + archivo, texto);
    }

    private static void crearArchivo(String directorio, String fichero) {
        File dir = new File(directorio);
        File file = new File(dir, fichero);

        if (!dir.exists() && dir.mkdirs()) {
            System.out.println("El Directorio se creó correctamente");
        } else if (dir.exists()) {
            System.out.println("El Directorio ya existe");
        } else {
            System.out.println("Error al crear directorio");
            return;
        }

        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    System.out.println("El Archivo se creó correctamente");
                    escribirTexto(file);
                } else {
                    System.out.println("Error al crear archivo");
                }
            } catch (IOException e) {
                System.out.println("IO Exception: " + e.getMessage());
            }
        } else {
            System.out.println("El Archivo ya existe");
        }
    }

    private static void escribirTexto(File file) {
        List<String> lista = List.of("Perro", "Gato", "Juan", "Daniel", "Juan", "Gato", "Perro", "Camila", "Daniel", "Camila");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (String s : lista) {
                bw.write(s);
                bw.newLine();
            }
            System.out.println("Datos guardados correctamente");
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    private static void buscarTexto(String nombreFichero, String texto) {
        File file = new File(nombreFichero);
        List<String> resultado = new ArrayList<>();

        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                br.lines()
                  .filter(s -> s.equals(texto))
                  .forEach(resultado::add);

                System.out.println("Cantidad de Repeticiones del Texto (" + texto + ") -> " + resultado.size());
            } catch (FileNotFoundException ex) {
                System.out.println("Error: " + ex.getMessage());
            } catch (IOException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        } else {
            System.out.println("El fichero ingresado no existe");
        }
    }

    private static String inputStr(String msge) {
        Scanner sc = new Scanner(System.in);
        String str;

        do {
            System.out.println(msge);
            str = sc.nextLine();
            if (str.isEmpty()) {
                System.out.println("Ingrese un Valor válido");
            }
        } while (str.isEmpty());

        sc.close();
        return str;
    }
}
