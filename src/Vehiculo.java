public class Vehiculo {
    private String color;
    private String patente;

    public Vehiculo() {
        // Constructor por defecto
    }

    public Vehiculo(String color, String patente) {
        this.color = color;
        this.patente = patente;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    @Override
    public String toString() {
        return String.format("Vehiculo{color='%s', patente='%s'}", color, patente);
    }
}
