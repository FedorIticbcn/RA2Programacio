public class DormAleatori extends Thread {
    private long tempsCreacio;

    public DormAleatori(String nom) {
        super(nom);
        this.tempsCreacio = System.currentTimeMillis();
    }
    
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                long tempsDormir = (long) (Math.random() * 1000);
                System.out.println(getName() + " (" + i + ") a dormir " + tempsDormir + "ms total " + (System.currentTimeMillis() - tempsCreacio) + " ms");
                sleep(tempsDormir);
            }
        } catch (InterruptedException e) {
            System.out.println("El fil " + getName() + " ha estat interromput.");
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        DormAleatori joan = new DormAleatori("Joan");
        DormAleatori pepe = new DormAleatori("Pepe");

        joan.start();
        pepe.start();
        System.out.println(" ---------- Fi de main ----------");
    }
}
