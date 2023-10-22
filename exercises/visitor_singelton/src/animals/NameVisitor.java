package animals;

public class NameVisitor implements AnimalVisitor<String>{
    @Override
    public String visit(Cat cat) {
        return cat.getName();
    }

    @Override
    public String visit(Dog dog) {
        return dog.getName();
    }
}
