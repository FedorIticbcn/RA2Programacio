public class Motor extends Thread{
    private int potenciaActual;
    private int potenciaObjectiu;
    private boolean haRebutOrdre;
    private boolean haMostratFerRes;

    public Motor(int id) {
        super("Motor " + id);
        this.potenciaActual = 0;
        this.potenciaObjectiu = 0;
        this.haRebutOrdre = false;
        this.haMostratFerRes = false;
    }

    public synchronized void setPotencia(int potencia) {
        this.potenciaObjectiu = potencia;
        this.haRebutOrdre = true;
        this.haMostratFerRes = false;
    }

    @Override
    public void run() {
        while (true) {
            int objectiu;
            boolean haRebut;
            boolean haMostrat;
            synchronized (this) {
                objectiu = potenciaObjectiu;
                haRebut = haRebutOrdre;
                haMostrat = haMostratFerRes;
            }
            if (haRebut && potenciaActual == objectiu && objectiu == 0) {
                System.out.println(getName() + " aturat");
                break;
            }
            String accio = "FerRes";
            if (potenciaActual < objectiu) {
                potenciaActual++;
                accio = "Incre.";
            } else if (potenciaActual > objectiu) {
                potenciaActual--;
                accio = "Decre.";
            }
            try {
                if (!accio.equals("FerRes")) {
                    System.out.println(getName() + ": " + accio
                        + " Objectiu: " + objectiu
                        + " Actual: " + potenciaActual);
                }
                if (accio.equals("FerRes") && haRebut && !haMostrat) {
                    synchronized (this) {
                        if (potenciaObjectiu == objectiu && !haMostratFerRes) {
                            haMostratFerRes = true;
                            System.out.println(getName() + ": FerRes"
                                + " Objectiu: " + objectiu
                                + " Actual: " + potenciaActual);
                        }
                    }
                }
                sleep((int)(1000 + Math.random() * 1000));
            } catch (InterruptedException e) {
                System.out.println(getName() + " ha estat interromput.");
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
