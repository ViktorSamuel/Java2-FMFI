import animals.*;
import trees.*;

public class Client {
    public static void main(String[] args) {

        System.out.println("Animal Visitor Pattern Test");

        System.out.println("----------------------------");

        Animal dog = new Dog();
        Animal cat = new Cat();

        AnimalVisitor sound = new SoundVisitor();
        dog.accept(sound);
        cat.accept(sound);

        AnimalVisitor speed = new SpeedVisitor();
        dog.accept(speed);
        cat.accept(speed);

        AnimalVisitor name = new NameVisitor();
        System.out.println(dog.accept(name));
        System.out.println(cat.accept(name));

        System.out.println("----------------------------");
        System.out.println("");


        System.out.println("Tree Visitor Pattern Test");
        System.out.println("----------------------------");

        TreeNode tree = new InternalNode(1,
                new InternalNode(2,
                        new LeafNode(3),
                        new LeafNode(4)),
                new InternalNode(5,
                        new LeafNode(6),
                        new LeafNode(7)));

        TreeVisitor<Integer> id = new SizeVisitor();
        System.out.println(tree.accept(id));

        TreeVisitor<Void> print = new PreOrderPrintTreeVistor();
        System.out.println("Print Tree");
        tree.accept(print);

        TreeVisitor<Void> removeLeftMost = new RemoveLeftMostLeafVisitor();
        System.out.println("Remove Left Most Leaf");
        tree.accept(removeLeftMost);
        tree.accept(print);

        TreeVisitor<Void> removeLeafById = new RemoveLeafByIdVisitor(6);
        System.out.println("Remove Leaf By Id");
        tree.accept(removeLeafById);
        tree.accept(print);
    }
}
