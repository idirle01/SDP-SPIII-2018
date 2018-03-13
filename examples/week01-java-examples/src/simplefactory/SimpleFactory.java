package simplefactory;

import java.lang.reflect.InvocationTargetException;

public class SimpleFactory {
    public static Dog build(String s){
        String name = "simplefactory.impl." + s + "Dog";
        try {
            return (Dog) Class.forName(name).getConstructor().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.println("No such Dog!" + " " + e.getMessage());
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(SimpleFactory.build("Robot").bark());
//        System.out.println(SimpleFactory.build("Toy").bark());
        System.out.println(SimpleFactory.build("Physical").bark());
    }
}
