public class Associacio {
    private final int numSocis = 1000;
    private final Soci[] socis = new Soci[numSocis];

    public Associacio() {
        for(int i = 0; i < numSocis; i++) {
            socis[i] = new Soci();
        }
    }

    public void iniciaCompteTempsSocis() {
        for(int i = 0; i < numSocis; i++) {
            socis[i].start();
        }
    }

    public void esperaPeriodeSocis() {
        for(Soci soci : socis) {
            try {
                soci.join();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}
