
import java.util.Random;

public class Treballador extends Thread {
    private final float sou_anual_brut;
    private int edat_inici_treball;
    private int edat_fi_treball;
    private int edat_actual = 0;
    private float cobrat = 0.0f;
    private Random rnd = new Random();
    
    public Treballador(String nom, float sou_anual_brut, int edat_inici_treball, int edat_fi_treball) {
        super(nom);
        this.sou_anual_brut = sou_anual_brut;
        this.edat_inici_treball = edat_inici_treball;
        this.edat_fi_treball = edat_fi_treball;
    }

    private void cobra() {
        cobrat += sou_anual_brut / 12;
    }

    private void pagaImpostos() {
        cobrat -= sou_anual_brut / 12 * 0.24f;
    }

    public float getCobrat() {
        return cobrat;
    }

    public int getEdat() {
        return edat_actual;
    }

    @Override 
    public void run() {
        while (edat_actual < edat_fi_treball) {
            if (edat_actual >= edat_inici_treball) {
                for (int i = 0; i < 12; i++) {
                    cobra();
                    pagaImpostos();
                }
            }
            edat_actual++;
        }
    }
}
