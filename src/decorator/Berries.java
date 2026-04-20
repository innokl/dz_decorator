package decorator;


import dish.Dish;

public class Berries extends Decorator {

    public Berries(Dish dish) {
        super(dish);
    }

    @Override
    public String getDescription() {
        return super.getDish().getDescription() + " + Снежные ягоды";
    }

    @Override
    public int getCost() {
        return super.getDish().getCost() + 6;
    }
}
