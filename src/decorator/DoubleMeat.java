package decorator;

import dish.Dish;

public class DoubleMeat extends Decorator {

    public DoubleMeat(Dish dish) {
        super(dish);
    }

    @Override
    public String getDescription() {
        return super.getDish().getDescription() + " + Двойная порция оленины";
    }

    @Override
    public int getCost() {
        return super.getDish().getCost() + 20;
    }
}
