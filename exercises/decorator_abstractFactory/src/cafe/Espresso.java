package cafe;

import java.util.ArrayList;
import java.util.List;

public class Espresso implements Coffee{
    private double cost = 1;
    private List<String> ingredients = new ArrayList<>();

    public Espresso() {
        ingredients.add("Espresso");
    }

    @Override
    public double getCost() {
        return cost;
    }

    @Override
    public List<String> getIngredients() {
        return ingredients;
    }
}
