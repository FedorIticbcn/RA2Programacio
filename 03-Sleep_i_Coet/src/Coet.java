import java.util.Scanner;

public class Coet {
    private Motor[] motors = new Motor[4];

    public Coet() {
        for (int i = 0; i < motors.length; i++) {
            motors[i] = new Motor(i);
        }
    }

    public void arranca() {
        System.out.println("Iniciant motors del coet...");

        for (Motor motor : motors) {
            motor.start();
        }
    }

    public void passaAPotencia(int p) {
        if (p < 0 || p > 10) {
            System.out.println("Potencia incorrecta. Torna-ho a intentar.");
            return;
        }

        System.out.println("Passant a potència " + p);

        for (Motor motor : motors) {
            motor.setPotencia(p);
        }
    }

    public static void main(String[] args) {
        Coet coet = new Coet();
        coet.arranca();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Introdueix una nova potencia: ");
            if (!scanner.hasNext()) {
                coet.passaAPotencia(0);
                break;
            }
            if (!scanner.hasNextInt()) {
                System.out.println("Entrada incorrecta. Introdueix un número.");
                scanner.next();
                continue;
            }
            int potencia = scanner.nextInt();
            coet.passaAPotencia(potencia);
            if (potencia == 0) {
                break;
            }
        }

        for (Motor motor : coet.motors) {
            try {
                motor.join();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
                scanner.close();
                return;
            }
        }
        System.out.println("Tots els motors aturats.");
        scanner.close();
    }
}
