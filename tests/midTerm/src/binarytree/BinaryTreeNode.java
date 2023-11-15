package binarytree;

public interface BinaryTreeNode<T> {
    public T getValue();
    <E> E accept(TreeVisitor<T, E> visitor);
    public String toString();
}
