package trees;

public class RemoveLeftMostLeafVisitor implements TreeVisitor<Void>{
    @Override
    public Void visit(LeafNode node) {
        return null;
    }

    @Override
    public Void visit(InternalNode node) {
        if (node.getLeftChild() instanceof LeafNode) {
            node.setLeftChild(null);
        } else if (node.getLeftChild() != null) {
            node.getLeftChild().accept(this);
        }
        return null;
    }
}
