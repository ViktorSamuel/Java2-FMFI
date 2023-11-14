package AbstractFactory;

public class ClassicalTable implements Table{
    @Override
    public void putOn() {
        System.out.println("Putting on a classical table");
    }
}
