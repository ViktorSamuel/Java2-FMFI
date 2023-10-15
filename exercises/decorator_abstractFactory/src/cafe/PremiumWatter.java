package cafe;

import java.util.List;

public class PremiumWatter extends WaterDecorator{
    public PremiumWatter(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 50;
    }

    @Override
    public List<String> getIngredients() {
        List<String> ingredients = super.getIngredients();
        ingredients.add("Premium Water");
        return ingredients;
    }
}
