package abstractfactory.car;

import abstractfactory.car.CarWindow;

public class FordWindow implements CarWindow {
    @Override
    public String toString() {
        return getClass().toString();
    }
}
