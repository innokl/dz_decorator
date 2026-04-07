package decorator;


import dish.Dish;

public class Bread extends Decorator {

    public Bread(Dish dish) {
        super(dish);
    }

    @Override
    public String getDescription() {
        return dish.getDescription() + " + Нордская лепешка";
    }

    @Override
    public int getCost() {
        return dish.getCost() + 7;
    }
}
