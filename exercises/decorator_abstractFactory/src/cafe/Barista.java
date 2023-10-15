package cafe;

public class Barista {
    private Shelf shelf;

    public Barista(Shelf shelf) {
        this.shelf = shelf;
    }

    public Coffee getCoffee(String name) {
        switch (name) {
            case "expresso":
                return shelf.createExpresso();
            case "withMilk":
                return shelf.addMilk(shelf.createExpresso());
            case "withWhiskey":
                return shelf.addWhiskey(shelf.createExpresso());
            case "withMilkFoam":
                return shelf.addMiklFoam(shelf.createExpresso());
            case "withWater":
                return shelf.addWater(shelf.createExpresso());
            default:
                return null;
        }
    }


}
