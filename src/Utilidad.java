public class Utilidad {
    public Utilidad(){
        limpiarPantalla();
        TiempoEspera();
    }

    private void limpiarPantalla() {
        System.out.println("Pantalla limpiada.");
    }

    private void TiempoEspera() {
        try {
            Thread.sleep(1000);
            System.out.println("Tiempo de espera completado.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
