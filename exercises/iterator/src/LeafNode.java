public class LeafNode implements TreeNode{
    private final int id;

    public LeafNode(int id) {
        this.id = id;
    }

    @Override
    public int getID() {
        return id;
    }
}
