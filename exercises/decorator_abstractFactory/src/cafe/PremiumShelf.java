package cafe;

public class PremiumShelf extends Shelf{
    @Override
    public Coffee createExpresso() {
        return new PremiumEspresso();
    }

    @Override
    public Coffee addMilk(Coffee basis) {
        return new MilkDecorator(basis);
    }

    @Override
    public Coffee addMiklFoam(Coffee basis) {
        return new WhippedCreamDecorator(basis);
    }

    @Override
    public Coffee addWater(Coffee basis) {
        return new PremiumWatter(basis);
    }

    @Override
    public Coffee addWhiskey(Coffee basis) {
        return new WhiskeyDecorator(basis);
    }

}
