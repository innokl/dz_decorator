package decorator;

import dish.Dish;

public abstract class Decorator implements Dish {
    private Dish dish;

    public Decorator(Dish dish) {
        this.dish = dish;
    }
    public Dish getDish() {
        return dish;
    }
}
