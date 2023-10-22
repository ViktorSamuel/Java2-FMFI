package trees;

public class RemoveLeafByIdVisitor implements TreeVisitor<Void>{
    private int id;

    public RemoveLeafByIdVisitor(int id) {
        this.id = id;
    }

    @Override
    public Void visit(LeafNode node) {
        return null;
    }

    @Override
    public Void visit(InternalNode node) {
        if (node.getLeftChild() != null && node.getLeftChild() instanceof LeafNode) {
            if (node.getLeftChild().getId() == id) {
                node.setLeftChild(null);
            }
        } else if (node.getLeftChild() != null){
            node.getLeftChild().accept(this);
        }
        if (node.getRightChild() != null && node.getRightChild() instanceof LeafNode) {
            if (node.getRightChild().getId() == id) {
                node.setRightChild(null);
            }
        } else if (node.getRightChild() != null){
            node.getRightChild().accept(this);
        }
        return null;
    }
}
