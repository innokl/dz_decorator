package dish;

public class BaseRagy implements Dish {

    @Override
    public String getDescription() {
        return "Нордское рагу";
    }

    @Override
    public int getCost() {
        return 50;
    }
}