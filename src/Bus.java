public class Bus extends Vehiculo {
    private int cantidadDeAsientos;

    public Bus() {
        // Constructor vacío
    }

    public Bus(String color, String patente, int cantidadDeAsientos) {
        super(color, patente);
        this.cantidadDeAsientos = cantidadDeAsientos;
    }

    public int getAsientosDisponibles() {
        return cantidadDeAsientos;
    }

    public int getCantidadDeAsientos() {
        return cantidadDeAsientos;
    }

    public void setCantidadDeAsientos(int cantidadDeAsientos) {
        this.cantidadDeAsientos = cantidadDeAsientos;
    }

    @Override
    public String toString() {
        return String.format("Bus{cantidadDeAsientos=%d} %s", cantidadDeAsientos, super.toString());
    }
}
