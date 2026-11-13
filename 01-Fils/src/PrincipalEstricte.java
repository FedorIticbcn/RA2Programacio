public class PrincipalEstricte {

    public static void main(String[] args) {
        System.out.println("Inici del programa");

        Fil juan = new Fil("Juan", 1);
        Fil pepe = new Fil("Pepe", 1);
        
        juan.setPriority(Thread.NORM_PRIORITY);
        pepe.setPriority(Thread.NORM_PRIORITY);

        juan.start();
        pepe.start();
        System.out.println("Termina thread main");
    }
}
