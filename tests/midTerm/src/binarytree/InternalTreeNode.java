package binarytree;

public class InternalTreeNode<T> implements BinaryTreeNode<T> {
    private T val;
    private BinaryTreeNode<T> left;
    private BinaryTreeNode<T> right;

    public InternalTreeNode(T val, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public BinaryTreeNode<T> getLeft() {
        return this.left;
    }

    public BinaryTreeNode<T> getRight() {
        return this.right;
    }

    @Override
    public T getValue() {
        return this.val;
    }

    @Override
    public <E> E accept(TreeVisitor<T, E> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "(val: " + this.val + " " + this.left.toString() + " " + this.right.toString() + ")";
    }

    public Memo<T> saveToMemento() {
        return new Memento<T>(this, this.left, this.right);
    }

    public class Memento<T> implements Memo<T>{
        private T mVal;
        private Memento<T> mLeft, mRight;

        private Memento(BinaryTreeNode<T> node) {
            mVal = node.getValue();
            if(mLeft == null)
                mLeft = new Memento<T>(node);
            else if (mRight == null) {
                mRight = new Memento<T>(node);
            }
        }

        private Memento(BinaryTreeNode<T> node, BinaryTreeNode<T> leftNode, BinaryTreeNode<T> rightNode) {
            mVal = node.getValue();
            mLeft = new Memento<T>(leftNode);
            mRight = new Memento<T>(rightNode);
        }

        private T getVal() {
            return mVal;
        }

    }
}