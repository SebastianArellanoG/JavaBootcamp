public class Vendedor extends Persona {
    private String direccion;

    public Vendedor() {
        // Constructor por defecto
    }

    public Vendedor(String rut, String nombre, int edad, String direccion) {
        super(rut, nombre, edad);
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return String.format("Vendedor{direccion='%s'} %s", direccion, super.toString());
    }
}
