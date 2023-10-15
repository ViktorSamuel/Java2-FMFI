package cafe;

import java.util.List;

public class WaterDecorator extends Decorator{
    public WaterDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return super.getCost();
    }

    @Override
    public List<String> getIngredients() {
        List<String> ingredients = super.getIngredients();
        ingredients.add("Water");
        return ingredients;
    }
}
