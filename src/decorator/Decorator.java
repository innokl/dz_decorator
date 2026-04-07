package decorator;

import dish.Dish;

public abstract class Decorator implements Dish {
    protected Dish dish;

    public Decorator(Dish dish) {
        this.dish = dish;
    }
}