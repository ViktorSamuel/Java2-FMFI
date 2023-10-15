package cafe;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Client {
    public static void main(String[] args) {
        Coffee expresso = new Espresso();
        Coffee withMilk = new MilkDecorator(expresso);
        Coffee withMilkAndWhiskey = new WhiskeyDecorator(withMilk);
        Coffee allInOne = new WhippedCreamDecorator(new MilkDecorator(new WhiskeyDecorator(new Espresso())));

        LinkedHashMap<String, Coffee> coffeeMap = new LinkedHashMap<>();
        coffeeMap.put("expresso", expresso);
        coffeeMap.put("withMilk", withMilk);
        coffeeMap.put("withMilkAndWhiskey", withMilkAndWhiskey);
        coffeeMap.put("allInOne", allInOne);

        for (String key : coffeeMap.keySet()) {
            System.out.println(key + ": " + coffeeMap.get(key).getCost() + " " + coffeeMap.get(key).getIngredients());
        }

    }
}
