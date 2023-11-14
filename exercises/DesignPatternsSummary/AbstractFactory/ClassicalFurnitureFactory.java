package AbstractFactory;

public class ClassicalFurnitureFactory implements FurnitureFactory{
    @Override
    public Chair createChair() {
        return new ClassicalChair();
    }

    @Override
    public Table createTable() {
        return new ClassicalTable();
    }
}
