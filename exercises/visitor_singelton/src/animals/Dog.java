package animals;

public class Dog implements Animal{
    private String sound = "bark";
    private int speed = 32;
    private String name = "Dog";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSound() {
        return sound;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public <T> T accept(AnimalVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
