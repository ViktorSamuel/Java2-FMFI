package cafe;

import java.util.List;

public class PremiumEspresso extends Espresso{
    public PremiumEspresso() {
        super();
    }
    @Override
    public double getCost() {
        return super.getCost() + 50;
    }

    @Override
    public List<String> getIngredients() {
        List<String> ingredients = super.getIngredients();
        ingredients.add("Premium Espresso");
        return ingredients;
    }
}
