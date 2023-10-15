package cafe;

public interface Shelf {
    Coffee createExpresso();
    Coffee addMilk(Coffee basis);
    Coffee addMiklFoam(Coffee basis);
    Coffee addWater(Coffee basis);
    Coffee addWhiskey(Coffee basis);
}
