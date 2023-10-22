package animals;

public class SpeedVisitor implements AnimalVisitor<Void>{
    @Override
    public Void visit(Cat cat)  {
        System.out.println(cat.getSpeed());
        return null;
    }

    @Override
    public Void visit(Dog dog)  {
        System.out.println(dog.getSpeed());
        return null;
    }
}
