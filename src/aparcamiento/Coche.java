package aparcamiento;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gonzalo
 */
public class Coche implements Runnable {

    ParkingSync parking;
    int nro_coche;

    public Coche(ParkingSync parking, int nro_coche) {
        super();
        this.parking = parking;
        this.nro_coche = nro_coche;
    }

    @Override
    public void run() {
        boolean aparcado = false;
        int plaza = -1;
        while (true) {
            if (aparcado) {
                try {
                    //Dormimos el hilo como mucho 3 segundos
                    Thread.sleep((long) (Math.random() * 3_000));
                    parking.salir(plaza, nro_coche);
                    aparcado = false;
                } catch (InterruptedException ex) {
                    Logger.getLogger(Coche.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                try {
                    Thread.sleep((long) (Math.random() * 3_000));
                } catch (InterruptedException ex) {
                    Logger.getLogger(Coche.class.getName()).log(Level.SEVERE, null, ex);
                }
                Integer resultado = parking.entrar(nro_coche);
                if (resultado != null) {
                    plaza = resultado;
                    aparcado = true;
                }
            }
        }
    }
}
