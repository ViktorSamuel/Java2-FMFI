package cafe;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class LoggerDecorator implements Shelf{
    private Shelf decoratedShelf;
    private String logFileName;

    public LoggerDecorator(Shelf decoratedShelf, String logFileName) {
        this.decoratedShelf = decoratedShelf;
        this.logFileName = logFileName;
    }

    @Override
    public Coffee createExpresso() {
        Coffee espresso = decoratedShelf.createExpresso();
        logIngredients("Espresso", espresso);
        return espresso;
    }

    @Override
    public Coffee addMilk(Coffee basis) {
        Coffee coffee = decoratedShelf.addMilk(basis);
        logIngredients("Milk", coffee);
        return coffee;
    }

    @Override
    public Coffee addMilkFoam(Coffee basis) {
        Coffee coffee = decoratedShelf.addMiklFoam(basis);
        logIngredients("Milk Foam", coffee);
        return coffee;
    }

    @Override
    public Coffee addWater(Coffee basis) {
        Coffee coffee = decoratedShelf.addWater(basis);
        logIngredients("Water", coffee);
        return coffee;
    }

    @Override
    public Coffee addWhiskey(Coffee basis) {
        Coffee coffee = decoratedShelf.addWhiskey(basis);
        logIngredients("Whiskey", coffee);
        return coffee;
    }

    private void logIngredients(String ingredient, Coffee coffee) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(logFileName, true));
            writer.write("Added " + ingredient + " to coffee with ingredients: " + coffee.getIngredients());
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
}
