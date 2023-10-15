package cafe;

import java.util.List;

public class Decorator implements Coffee{
    private final Coffee coffee;

    public Decorator(Coffee coffee){
        this.coffee = coffee;
    }

    @Override
    public double getCost() {
        return coffee.getCost();
    }

    @Override
    public List<String> getIngredients() {
        return coffee.getIngredients();
    }
}
