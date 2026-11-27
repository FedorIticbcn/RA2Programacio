import java.util.Random;

public class Soci extends Thread {
    private final Compte compte;
    private final float aportacio = 10.0f;
    private final int esperaMax = 100;
    private final Random rnd = new Random();
    private final int maxAnys = 10;

    public Soci() {
        this.compte = Compte.getInstance();
    }

    public Compte getCompte() {
        return compte;
    }

    @Override
    public void run() {
        for(int i = 0; i < maxAnys; i++) {
            for(int j = 0; j < 12; j++) {
                if(j%2 == 0) {
                    compte.setSaldo(compte.getSaldo() + aportacio);
                } else {
                    compte.setSaldo(compte.getSaldo() - aportacio);
                }
                try {
                    Thread.sleep(rnd.nextInt(esperaMax));
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                    Thread.currentThread().interrupt();
                    return;
                }    
            }
        }
    }
}