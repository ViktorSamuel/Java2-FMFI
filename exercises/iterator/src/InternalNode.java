public class InternalNode implements TreeNode{
    private final int id;
    private final TreeNode left;
    private final TreeNode right;

    public InternalNode(int id, TreeNode left, TreeNode right) {
        this.id = id;
        this.left = left;
        this.right = right;
    }

    @Override
    public int getID() {
        return id;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }
}
