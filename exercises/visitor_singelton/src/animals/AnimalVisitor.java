package animals;

public interface AnimalVisitor<T> {
    T visit(Cat cat);
    T visit(Dog dog);
}
