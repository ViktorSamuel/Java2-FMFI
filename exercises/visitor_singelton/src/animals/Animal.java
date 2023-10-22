package animals;

public interface Animal {
    String getSound();
    int getSpeed();
    String getName();
    <T> T accept(AnimalVisitor<T> visitor);
}
