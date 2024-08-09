import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ExportadorTxt extends ExportarTxt {

    @Override
    public void exportar() {
        ProductoServicio listaProductos = ProductoServicio.getInstance();
        File dir = new File("src/txt");

        if (!dir.exists() && !dir.mkdir()) {
            System.out.println("Error al Crear el directorio");
            return;
        }

        File file = new File(dir, "data.txt");

        try {
            if (!file.exists() && !file.createNewFile()) {
                System.out.println("No se puede crear el archivo");
                return;
            }
        } catch (IOException e) {
            System.out.println("Error I/O: " + e.getMessage());
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (Producto p : listaProductos.getListaProductos()) {
                bw.write(String.format("%s,%d,%s,%d,%s,%s,%s",
                        p.getArticulo(), p.getPrecio(), p.getDescripcion(),
                        p.getCodigo(), p.getTalla(), p.getMarca(), p.getColor()));
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error I/O: " + e.getMessage());
        }
    }
}
