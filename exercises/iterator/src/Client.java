import java.util.Iterator;

public class Client {
    public static void main(String[] args) {
        TreeNode root = new InternalNode(1,
            new InternalNode(2,
                new LeafNode(3),
                new LeafNode(4)),
            new LeafNode(5));

        Iterator<TreeNode> iterator = new TreeIterable(root).iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next().getID());
        }
    }
}
