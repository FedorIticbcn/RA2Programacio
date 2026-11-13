public class PrincipalDiferents {
    public static void main(String[] args) {
        System.out.println("Inici del programa");

        Fil juan = new Fil("Juan", 0);
        Fil pepe = new Fil("Pepe", 0);

        pepe.setPriority(Thread.MIN_PRIORITY);
        juan.setPriority(Thread.MAX_PRIORITY);

        pepe.start();
        juan.start();

        System.out.println("Termina thread main");
    }
}
