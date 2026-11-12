public class Fil extends Thread {

    private String nom;
    private int delay;

    public Fil(String nom, int delay) {
        this.nom = nom;
        this.delay = delay;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(nom + " " + i);
            if(delay > 0) {
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        Fil juan = new Fil("Juan", 0);
    }
}
