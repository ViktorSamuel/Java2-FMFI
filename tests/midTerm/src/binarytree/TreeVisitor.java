package binarytree;

public interface TreeVisitor<T, E> {
    E visit(InternalTreeNode<T> node); 
    E visit(Leaf<T> node);
}
