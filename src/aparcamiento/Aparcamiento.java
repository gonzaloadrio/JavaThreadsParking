package aparcamiento;

/**
 *
 * @author gonzalo
 */
public class Aparcamiento {

    public static void main(String[] args) {

        int nro_plazas = 5;
        int nro_coches = 10;
        ParkingSync parking = new ParkingSync(nro_plazas);
        for (int i = 0; i < nro_coches; i++) {
            Thread t = new Thread(new Coche(parking, i));
            t.start();
        }
    }

}
