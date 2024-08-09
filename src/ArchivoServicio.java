import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ArchivoServicio {
    private static ArchivoServicio instance;

    private ArchivoServicio() {}

    public static ArchivoServicio getInstance() {
        if (instance == null) {
            instance = new ArchivoServicio();
        }
        return instance;
    }

    public void cargarDatos(String ruta) {
        String fullPath = "src/cl/praxis/curso/M4/desafio_m4_dia28/" + ruta;
        File archivo = new File(fullPath);

        if (!archivo.exists()) {
            System.out.println("El Archivo No existe:");
            return;
        }

        try (FileReader fr = new FileReader(fullPath);
             BufferedReader br = new BufferedReader(fr)) {

            br.lines().forEach(row -> {
                String[] data = row.split(",");
                if (data.length == 7) {
                    ProductoServicio productoServicio = ProductoServicio.getInstance();
                    productoServicio.agregarProducto(new Producto(
                        data[0],
                        Integer.parseInt(data[1]),
                        data[2],
                        Integer.parseInt(data[3]),
                        data[4],
                        data[5],
                        data[6]
                    ));
                }
            });

            System.out.println("Datos cargados correctamente en la lista:");
        } catch (IOException e) {
            System.out.println("Error I/O: " + e.getMessage());
        }
    }
}
