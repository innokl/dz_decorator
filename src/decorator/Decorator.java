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
    @Override
    public String getDescription(){
        return dish.getDescription();
    }

    @Override
    public int getCost(){
        return dish.getCost();
    }
}
