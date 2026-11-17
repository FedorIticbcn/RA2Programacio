public class MainDemoFil {
    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        System.out.println("Nom del fil: " + thread.getName());
        System.out.println("Prioritat del fil: " + thread.getPriority());
        System.out.println(thread.toString());
    }
}
