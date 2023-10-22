package animals;

public class Cat implements Animal {
    private String sound = "meow";
    private int speed = 48;
    private String name = "Cat";

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
