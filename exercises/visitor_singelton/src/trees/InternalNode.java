package trees;

import animals.AnimalVisitor;

public class InternalNode implements TreeNode{
    private TreeNode left, right;
    private int id;
    public InternalNode(int id, TreeNode left, TreeNode right) {
        this.id = id;
        this.left = left;
        this.right = right;
    }
    @Override
    public int getId() {
        return id;
    }
    public TreeNode getLeftChild() {
        return left;
    }
    public TreeNode getRightChild() {
        return right;
    }
    public void setLeftChild(TreeNode left) {
        this.left = left;
    }
    public void setRightChild(TreeNode right) {
        this.right = right;
    }

    @Override
    public <T> T accept(TreeVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
