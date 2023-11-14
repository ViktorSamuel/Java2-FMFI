package AbstractFactory;

public class ModernTable implements Table{
    @Override
    public void putOn() {
        System.out.println("Putting on a modern table");
    }
}
