package binarytree;

public class DepthVisitor<T> implements TreeVisitor<T, Integer> {

    public Integer visit(InternalTreeNode<T> node) {
        return 1 + Math.max(node.getLeft().accept(this), node.getRight().accept(this));
    }

    @Override
    public Integer visit(Leaf<T> node) {
        return 0;
    }
}
