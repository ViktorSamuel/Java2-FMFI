package cafe;

import java.util.List;

public class WhippedCreamDecorator extends Decorator{
    public WhippedCreamDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 1;
    }

    @Override
    public List<String> getIngredients() {
        List<String> ingredients = super.getIngredients();
        ingredients.add("Whipped Cream");
        return ingredients;
    }
}
