package aparcamiento;

/**
 *
 * @author gonzalo
 */
public class ParkingSync {

    private Integer[] plazas;

    public ParkingSync(int cantidadCoches) {
        plazas = new Integer[cantidadCoches];
    }

    public synchronized void salir(int nro_plaza, int nro_coche) {
        plazas[nro_plaza] = null;
        System.out.println("Coche: " + nro_coche + " deja la plaza: " + nro_plaza);
        print_plazas();
    }

    public void print_plazas() {
        System.out.print("Parking: ");
        int libres = 0;
        for (Integer plaza : plazas) {
            if (plaza == null) {
                libres++;
            }
            System.out.print("[" + plaza + "] ");
        }
        System.out.println("\nPlazas libres: " + libres);
    }

    public synchronized Integer entrar(int nro_coche) {

        for (int i = 0; i < plazas.length; i++) {
            if (plazas[i] == null) {
                plazas[i] = nro_coche;
                System.out.println("Coche: " + nro_coche + " entra en la plaza: " + i);
                print_plazas();
                return i;
            }
        }

        return null;
    }
}
