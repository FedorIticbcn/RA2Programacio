public class PrincipalIguals {
    public static void main(String[] args) {
        System.out.println("Inici del programa");

        Fil juan = new Fil("Juan", 0);
        Fil pepe = new Fil("Pepe", 0);

        juan.start();
        pepe.start();

        System.out.println("Acaba thread main");
    }
}
