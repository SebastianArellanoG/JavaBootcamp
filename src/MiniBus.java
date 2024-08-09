public class MiniBus extends Bus {
    private String tipoViaje;

    public MiniBus() {}

    public MiniBus(String color, String patente, int cantidadDeAsientos, String tipoViaje) {
        super(color, patente, cantidadDeAsientos);
        this.tipoViaje = tipoViaje;
    }

    public void imprimeBus() {
        System.out.printf(
                "MiniBus: {%n" +
                "   Color: '%s',%n" +
                "   Patente: '%s',%n" +
                "   Cantidad de Asientos: %d%n" +
                "   Tipo Viaje: '%s'%n" +
                "}%n",
                getColor(), getPatente(), getCantidadDeAsientos(), tipoViaje
        );
    }

    public String getTipoViaje() {
        return tipoViaje;
    }

    public void setTipoViaje(String tipoViaje) {
        this.tipoViaje = tipoViaje;
    }

    @Override
    public String toString() {
        return String.format("MiniBus{tipoViaje='%s'} %s", tipoViaje, super.toString());
    }
}
