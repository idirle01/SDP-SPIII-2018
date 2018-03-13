package singletonlazy;

public class Singleton {
    private static int counter = 0;
    private static Singleton single;

    private Singleton(){
        counter++;
    }

    public static Singleton getInstance(){
        if (single == null) {
            single = new Singleton();
        }
        return single;
    }

    @Override
    public String toString(){
        return getClass() + " " + hashCode() + " " + counter;
    }

    public static void main(String[] args) {
        final int LIMIT = 10;

        System.out.println(Singleton.counter);
        for(int x=0; x < LIMIT; x++){
            System.out.println(Singleton.getInstance());
        }
    }
}
