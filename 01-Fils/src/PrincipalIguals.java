public class PrincipalIguals {
    public static void main(String[] args) {
        System.out.println("Inici del programa");

        Fil juan = new Fil("Juan", 0);
        Fil pepe = new Fil("Pepe", 0);

        juan.setPriority(Thread.MAX_PRIORITY);
        pepe.setPriority(Thread.MIN_PRIORITY);
        juan.start();
        pepe.start();

        System.out.println("Termina thread main");
    }
}
