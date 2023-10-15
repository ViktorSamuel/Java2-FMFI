package cafe;

import java.util.List;

public class WhiskeyDecorator extends Decorator{
    public WhiskeyDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 2;
    }

    @Override
    public List<String> getIngredients() {
        List<String> ingredients = super.getIngredients();
        ingredients.add("Whiskey");
        return ingredients;
    }
}
