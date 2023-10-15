package cafe;

import java.util.List;

public class MilkFoamDecorator extends Decorator{
    public MilkFoamDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.5;
    }

    @Override
    public List<String> getIngredients() {
        List<String> ingredients = super.getIngredients();
        ingredients.add("Milk Foam");
        return ingredients;
    }
}
