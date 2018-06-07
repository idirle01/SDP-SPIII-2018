package abstractfactory.car;

import abstractfactory.car.CarEngine;

public class FordEngine implements CarEngine {
    @Override
    public String toString() {
        return getClass().toString();
    }
}
