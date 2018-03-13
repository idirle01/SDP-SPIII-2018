package simplefactory.impl;

import simplefactory.Dog;

public class RobotDog implements Dog {
    @Override
    public String bark() {
        return getClass() + " Roof!";
    }
}
