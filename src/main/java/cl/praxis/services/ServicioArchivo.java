package cl.praxis.services;

import cl.praxis.modelos.CategoriaEnum;
import cl.praxis.modelos.Cliente;

import java.io.*;
import java.util.List;

public class ServicioArchivo extends Exportador {
    private static ServicioArchivo instancia;

    private ServicioArchivo() {}

    public static synchronized ServicioArchivo getInstancia() {
        if (instancia == null) {
            instancia = new ServicioArchivo();
        }
        return instancia;
    }

    @Override
    public void exportar(String fileName, List<Cliente> listaClientes) {
        System.out.println("--------------- Datos Exportados ----------------");

        File archivo = new File(fileName);

        try (FileWriter fw = new FileWriter(archivo, false);
             PrintWriter pw = new PrintWriter(fw)) {

            if (!archivo.exists() && !archivo.createNewFile()) {
                System.out.println("No se pudo crear el archivo " + fileName);
                return;
            }

            for (Cliente cliente : listaClientes) {
                pw.println(cliente);
            }

        } catch (IOException e) {
            System.out.println("No se pudo escribir en el archivo: " + e.getMessage());
        }
    }

    public void cargarDatos(String fileName) {
        System.out.println("------------- Datos Importados ---------------");

        try (FileReader fr = new FileReader(fileName);
             BufferedReader br = new BufferedReader(fr)) {

            br.lines().forEach(fila -> {
                String[] data = fila.split(",");

                if (data.length == 5) {
                    Cliente cliente = new Cliente();
                    cliente.setRun(Integer.parseInt(data[0]));
                    cliente.setNombre(data[1]);
                    cliente.setApellido(data[2]);
                    cliente.setAnios(Integer.parseInt(data[3]));
                    cliente.setCategoria(CategoriaEnum.valueOf(data[4]));

                    ServicioCliente sc = ServicioCliente.getInstancia();
                    sc.agregarCliente(cliente);
                }
            });

            System.out.println("Datos Cargados Correctamente");
        } catch (IOException e) {
            System.out.println("Error al cargar datos: " + e.getMessage());
        }
    }
}
