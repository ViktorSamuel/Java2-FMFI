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
    public String toString() {
        return "(val: " + this.val + ")";
    }

    public Memo<T> saveToMemento() {
        return new Memento<T>(this);
    }

    public void restoreFromMemento(Memento<T> m) {
        this.val = m.getVal();
    }

    public class Memento<T> implements Memo<T>{
        private T mVal;

        private Memento(BinaryTreeNode<T> node) {
            mVal = node.getValue();
        }

        private T getVal() {
            return mVal;
        }
    }
}
