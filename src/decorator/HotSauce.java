package decorator;

import dish.Dish;

public class HotSauce extends Decorator {

    public HotSauce(Dish dish) {
        super(dish);
    }

    @Override
    public String getDescription() {
        return dish.getDescription() + " + Огненный соус";
    }

    @Override
    public int getCost() {
        return dish.getCost() + 10;
    }
}