package cl.praxis.view;

import cl.praxis.modelos.CategoriaEnum;
import cl.praxis.modelos.Cliente;
import cl.praxis.services.ServicioArchivo;
import cl.praxis.services.ServicioCliente;
import cl.praxis.utils.Consola;

import java.util.ArrayList;

public class Menu {
    private final ServicioCliente servicioCliente;
    private final ServicioArchivo servicioArchivo;
    private static final String FILE_NAME_EXPORTAR = "Clientes";
    private static final String FILE_NAME_IMPORTAR = "DBClientes.csv";

    public Menu() {
        servicioCliente = ServicioCliente.getInstancia();
        servicioArchivo = ServicioArchivo.getInstancia();
    }

    public void iniciarMenu() {
        ArrayList<String> opciones = new ArrayList<>();
        opciones.add("1. Listar Clientes");
        opciones.add("2. Agregar Cliente");
        opciones.add("3. Editar Cliente");
        opciones.add("4. Cargar Datos");
        opciones.add("5. Exportar Datos");
        opciones.add("6. Salir");

        int opcion;
        do {
            Consola.limpiarConsola();
            mostrarMenu(opciones);
            opcion = Consola.inputInt("Ingrese una Opcion:");

            if (opcion >= 1 && opcion <= opciones.size()) {
                System.out.println(opciones.get(opcion - 1));
                ejecutarOpcion(opcion);
            } else {
                System.out.println("Ingrese una Opcion Valida (Menu)");
            }
        } while (opcion != opciones.size());
    }

    private void mostrarMenu(ArrayList<String> opciones) {
        System.out.println("--------------------- Menu ----------------------");
        for (String op : opciones) {
            System.out.println(op);
        }
        System.out.println("-------------------------------------------------");
    }

    private void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                listarCliente();
                break;
            case 2:
                agregarCliente();
                break;
            case 3:
                editarCliente();
                break;
            case 4:
                importarDatos();
                break;
            case 5:
                exportarDatos();
                break;
            case 6:
                terminarPrograma();
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }
    }
    public void listarCliente() {
        servicioCliente.listarClientes();
    }

    public void agregarCliente() {
        System.out.println("----------------- Crear Cliente -----------------");
        int rut = Consola.inputInt("Ingresa RUN del Cliente:");
        String nombre = Consola.inputStr("Ingresa Nombre del Cliente:");
        String apellido = Consola.inputStr("Ingresa Apellido del Cliente:");
        int anio = Consola.inputInt("Ingresa Años como Cliente:");

        Cliente nuevoCliente = new Cliente(rut, nombre, apellido, anio, CategoriaEnum.ACTIVO);
        servicioCliente.agregarCliente(nuevoCliente);

        System.out.println("Cliente Creado Correctamente");
    }

    public void editarCliente() {
        System.out.println("---------------- Editar Cliente -----------------");
        System.out.println("Seleccione que Desea Hacer:");
        System.out.println("1.- Cambiar el Estado del Cliente");
        System.out.println("2.- Editar los Datos Ingresados del Cliente");
        System.out.println("-------------------------------------------------");

        int opcion;
        do {
            opcion = Consola.inputInt("Ingrese una Opcion");
            if (opcion == 1 || opcion == 2) {
                int run = Consola.inputInt("Ingrese el Rut del Cliente a Editar");
                Cliente cliente = servicioCliente.getClienteByRun(run);

                if (cliente == null) {
                    System.out.println("El Cliente no Existe");
                    return;
                }

                if (opcion == 1) {
                    editarClienteEstado(cliente);
                } else {
                    editarClienteDatos(cliente);
                }
            } else {
                System.out.println("Ingrese una Opcion Valida (menuEditar)");
            }
        } while (opcion != 1 && opcion != 2);
    }

    private void editarClienteEstado(Cliente cliente) {
        System.out.println("-------- Actualizando Estado del Cliente --------");
        System.out.println("El Estado actual del cliente es: " + cliente.getCategoria());
        System.out.println("1.- Si Desea Cambiar el Estado del Cliente a Inactivo");
        System.out.println("2.- Si Desea Mantener el Estado del Cliente Activo");
        System.out.println("-------------------------------------------------");

        int opcion;
        do {
            opcion = Consola.inputInt("Ingrese una Opcion");
            if (opcion == 1) {
                cliente.setCategoria(CategoriaEnum.INACTIVO);
                System.out.println("Estado Modificado Correctamente a Inactivo");
            } else if (opcion == 2) {
                cliente.setCategoria(CategoriaEnum.ACTIVO);
                System.out.println("Estado Modificado Correctamente a Activo");
            } else {
                System.out.println("Ingrese una Opcion Valida (menuEditarEstado)");
            }
        } while (opcion != 1 && opcion != 2);
    }

    private void editarClienteDatos(Cliente cliente) {
        System.out.println("-------- Actualizando Datos del Cliente ---------");
        System.out.println("1.- El RUN del Cliente es: " + cliente.getRun());
        System.out.println("2.- El Nombre del Cliente es: " + cliente.getNombre());
        System.out.println("3.- El Apellido del Cliente es: " + cliente.getApellido());
        System.out.println("4.- Los Años como Cliente son: " + cliente.getAnios());
        System.out.println("-------------------------------------------------");


        int opcion;
        do {
            opcion = Consola.inputInt("Ingrese una Opcion");
            switch (opcion) {
                case 1:
                    int nuevoRut = Consola.inputInt("Ingrese Nuevo Rut del Cliente");
                    cliente.setRun(nuevoRut);
                    System.out.println("RUT Modificado Correctamente");
                    break;
                case 2:
                    String nombre = Consola.inputStr("Ingrese Nuevo Nombre del Cliente");
                    cliente.setNombre(nombre);
                    System.out.println("Nombre Modificado Correctamente");
                    break;
                case 3:
                    String apellido = Consola.inputStr("Ingrese Nuevo Apellido del Cliente");
                    cliente.setApellido(apellido);
                    System.out.println("Apellido Modificado Correctamente");
                    break;
                case 4:
                    int anios = Consola.inputInt("Ingrese Nuevo Años como Cliente");
                    cliente.setAnios(anios);
                    System.out.println("Años como Cliente Modificado Correctamente");
                    break;
                default:
                    System.out.println("Ingrese una Opcion Valida (menuEditarEstado)");
                    break;
            }
        } while (opcion < 1 || opcion > 4);
    }

    public void importarDatos() {
        servicioArchivo.cargarDatos(obtenerRuta(true, FILE_NAME_IMPORTAR));
    }

    private String obtenerRuta(boolean isImportar, String fileName) {
        String os = System.getProperty("os.name").toLowerCase();
        String mensaje = isImportar ? "Ingrese la ruta en donde se encuentra el archivo " + fileName
                                    : "Ingrese la ruta en donde desea exportar el archivo " + fileName;
        String mensaje2 = isImportar ? "Importar" : "Exportar";
        String ruta;

        if (os.contains("win")) {
            do {
                System.out.println("----------- " + mensaje2 + " Datos en Windows -----------");
                System.out.println(mensaje);
                ruta = Consola.inputStr("C:\\usuario\\equipo\\Desktop");
            } while (!validarRutaWin(ruta));
            ruta = ruta.endsWith("\\") ? ruta : ruta.concat("\\");
        } else {
            do {
                System.out.println("---------- " + mensaje2 + " Datos en Linux o Mac ----------");
                System.out.println(mensaje);
                ruta = Consola.inputStr("/home/usuario/Desktop");
            } while (!validarRutaLinuxMac(ruta));
            ruta = ruta.endsWith("/") ? ruta : ruta.concat("/");
        }

        return ruta.concat(fileName);
    }

    private boolean validarRutaWin(String ruta) {
        return ruta.matches("^[a-zA-Z]:\\\\.*$");
    }

    private boolean validarRutaLinuxMac(String ruta) {
        return ruta.startsWith("/") || ruta.startsWith("~/");
    }

    public void exportarDatos() {
        System.out.println("---------------- Exportar Datos -----------------");
        System.out.println("1.- Formato csv");
        System.out.println("2.- Formato txt");
        System.out.println("-------------------------------------------------");

        int opcion;
        do {
            opcion = Consola.inputInt("Ingrese una Opcion");
            if (opcion == 1 || opcion == 2) {
                String extension = opcion == 1 ? ".csv" : ".txt";
                servicioArchivo.exportar(obtenerRuta(false, FILE_NAME_EXPORTAR.concat(extension)), servicioCliente.listaClientes());
                System.out.println("Datos de " + FILE_NAME_EXPORTAR + " Exportados correctamente en formato " + extension);
            } else {
                System.out.println("Ingrese una Opcion Valida (menuExportarDatos)");
            }
        } while (opcion != 1 && opcion != 2);
    }

    private void terminarPrograma() {
        System.out.println("Saliendo del sistema...");
    }
}
