package simplefactory.impl;

import simplefactory.Dog;

public class PhysicalDog implements Dog {
    @Override
    public String bark() {
        return getClass() + " Woof!";
    }
}