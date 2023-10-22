package trees;

public class PreOrderPrintTreeVistor implements TreeVisitor<Void>{
    @Override
    public Void visit(LeafNode node) {
        System.out.println(node.getId());
        return null;
    }

    @Override
    public Void visit(InternalNode node) {
        System.out.println(node.getId());
        if (node.getLeftChild() != null){
            node.getLeftChild().accept(this);
        }
        if (node.getRightChild() != null){
            node.getRightChild().accept(this);
        }
        return null;
    }
}
