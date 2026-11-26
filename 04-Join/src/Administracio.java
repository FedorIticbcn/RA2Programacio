public class Administracio {
    private static final int num_poblacio_activa = 50;
    private final Treballador[] poblacio_activa = new Treballador[num_poblacio_activa];

    public Administracio() {
        for (int i = 0; i < num_poblacio_activa; i++) {
            poblacio_activa[i] = new Treballador("Ciutadà-" + i, 25000.0f, 20, 65);
        }
    }

    public static void main(String[] args) {
        Administracio administracio = new Administracio();
        for (Treballador treballador : administracio.poblacio_activa) {
            treballador.start();
        }
        for (Treballador treballador : administracio.poblacio_activa) {
            try {
                treballador.join();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
                Thread.currentThread().interrupt();
                return;
            }
        }
        for (Treballador treballador : administracio.poblacio_activa) {
            System.out.printf("%s -> edat: %d / total: %.2f%n", treballador.getName(), treballador.getEdat(), treballador.getCobrat());
        }
    }
}
