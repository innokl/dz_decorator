package decorator;


import dish.Dish;

public class Bread extends Decorator {

    public Bread(Dish dish) {
        super(dish);
    }

    @Override
    public String getDescription() {
        return super.getDish().getDescription() + " + Нордская лепешка";
    }

    @Override
    public int getCost() {
        return super.getDish().getCost() + 7;
    }
}
