package trees;

import animals.AnimalVisitor;

public class LeafNode implements TreeNode{
    private final int id;
    public LeafNode(int id) {
        this.id = id;
    }
    @Override
    public int getId() {
        return id;
    }

    @Override
    public <T> T accept(TreeVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
