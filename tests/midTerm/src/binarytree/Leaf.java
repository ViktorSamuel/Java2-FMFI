package binarytree;

public class Leaf<T> implements BinaryTreeNode<T> {
    private T val;

    public Leaf(T val) {
        this.val = val;
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
        return "(val: " + this.val + ")";
    }

    public Memento saveToMemento() {
        return new Memento(this.val);
    }

    public void restoreFromMemento(Memento m) {
        val = (T) m.getVal();
    }

    public static class Memento<T> {
        private T val;

        private Memento(T val){
            this.val = val;
        }

        private T getVal() {
            return this.val;
        }
    }
}
