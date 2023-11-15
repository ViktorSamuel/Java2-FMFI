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
    public String toString(){
        return "(val: " + this.val + " " + this.left.toString() + " " + this.right.toString() + ")";
    }

    public Memento saveToMemento() {
        return new Memento(this.val, this.left.saveToMemento(), this.right.saveToMemento());
    }

    public void restoreFromMemento(Memento m) {
        this.val = (T) m.getVal();
        this.left = m.getLeft();
        this.right = m.getRight();
    }

    public static class Memento<T>{
        private T mementoVal;
        private Memento<T> mementoLeft;
        private Memento<T> mementoRight;

        public Memento(T val, Memento<T> left, Memento<T> right){
            this.mementoVal = val;
            this.mementoLeft = left;
            this.mementoRight = right;
        }

        private T getVal() {
            return this.mementoVal;
        }

        private BinaryTreeNode<T> getLeft() {
            return this.restoreFromMemento(this.mementoLeft);
        }

        private BinaryTreeNode<T> getRight() {
            return this.restoreFromMemento(this.mementoRight);
        }
    }
}