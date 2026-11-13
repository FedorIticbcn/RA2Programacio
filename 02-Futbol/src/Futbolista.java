public class Futbolista extends Thread {
    private static final int NUM_JUGADORS = 11;
    private static final int NUM_TIRADES = 20;
    private static final float PROBABILITAT = 0.5f;

    private int ngols;
    private int ntirades;

    public Futbolista(String nom) {
        super(nom);
        this.ngols = 0;
        this.ntirades = 0;
    }

    public int getNgols() {
        return this.ngols;
    }

    @Override
    public void run() {
        for (int i = 0; i < NUM_TIRADES; i++) {
            if (Math.random() < PROBABILITAT) {
                this.ngols++;
            }
            this.ntirades++;
        }
    }

    public static void main(String[] args) {
        Futbolista[] jugadors = new Futbolista[11];

        for (int i = 1; i <= 11; i++) {
            jugadors[i - 1] = new Futbolista("Jugador " + i);
        }

        System.out.println("Inici dels xuts");

        for (Futbolista jugador : jugadors) {
            
            jugador.start();
        }

        for (Futbolista jugador : jugadors) {
            try {
                jugador.join();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
                return;
            }
        }
        System.out.println("Fi dels xuts");
        System.out.println("---- Estadístiques ----");
        for (Futbolista jugador : jugadors) {
            System.out.println(jugador.getName() + " -> " + jugador.getNgols() + " gols");
        }

    }
}
