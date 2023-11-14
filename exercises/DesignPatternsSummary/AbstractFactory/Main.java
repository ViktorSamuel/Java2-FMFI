package AbstractFactory;

public class Main {
    public static void main(String[] args) {
        // Vytvorenie moderného nábytku
        FurnitureFactory modernFurnitureFactory = new ModernFurnitureFactory();
        Chair modernChair = modernFurnitureFactory.createChair();
        Table modernTable = modernFurnitureFactory.createTable();
        modernChair.sitOn();
        modernTable.putOn();

        // Vytvorenie klasického nábytku
        FurnitureFactory classicFurnitureFactory = new ClassicalFurnitureFactory();
        Chair classicChair = classicFurnitureFactory.createChair();
        Table classicTable = classicFurnitureFactory.createTable();
        classicChair.sitOn();
        classicTable.putOn();
    }
}
