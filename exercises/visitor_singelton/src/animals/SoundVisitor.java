package animals;

public class SoundVisitor implements AnimalVisitor<Void>{
    @Override
    public Void visit(Cat cat) {
        System.out.println(cat.getSound());
        return null;
    }

    @Override
    public Void visit(Dog dog) {
        System.out.println(dog.getSound());
        return null;
    }
}
