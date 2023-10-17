import java.util.Iterator;

public class Client {
    public static void main(String[] args) {
        TreeNode root = new InternalNode(5,
            new InternalNode(4,
                new LeafNode(3),
                new LeafNode(2)),
            new LeafNode(1));

        Iterator<TreeNode> iterator = root.orderedIterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next().getID());
        }
    }
}
