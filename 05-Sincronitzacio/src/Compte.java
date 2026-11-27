public class Compte {
    private float saldo;
    private static final Compte instance = new Compte();

    private Compte() {
        saldo = 0.0f;
    }

    public static Compte getInstance() {
        return instance;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
}
