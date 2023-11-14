package AbstractFactory;

public class ClassicalChair implements Chair{
    @Override
    public void sitOn() {
        System.out.println("Sitting on a classical chair");
    }
}
