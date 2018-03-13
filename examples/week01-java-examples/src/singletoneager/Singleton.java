package singletoneager;

public class Singleton {
    private static int counter;
    private static Singleton single;

    static {
        counter = 0;
        single = new Singleton();
    }

    private Singleton() {
        counter++;
    }

    public static Singleton getInstance() {
        return single;
    }

    @Override
    public String toString() {
        return getClass() + " " + hashCode() + " " + counter;
    }

    public static void main(String[] args) {
        final int LIMIT = 10;
        System.out.println(Singleton.counter);
        for (int x = 0; x < LIMIT; x++) {
            System.out.println(Singleton.getInstance());
        }
    }
}
