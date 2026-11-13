public class Fil extends Thread {

    private String nom;
    private int delay;

    public Fil(String nom, int delay) {
        this.nom = nom;
        this.delay = delay;
    }

    @Override
    public void run() {
        for (int i = 1; i < 10; i++) {
            int acumulado = 0;
            if(delay > 0) {
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                    return;
                }
            } else {
                for (int j = 1; j <= 1000; j++) {
                    acumulado += j;
                }
            } 
            
            System.out.println(nom + " " + i);
        }
        System.out.println("Termina el fil " + nom);
    }
}
