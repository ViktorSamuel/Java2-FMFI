package trees;

public class SizeVisitor implements TreeVisitor<Integer>{
    @Override
    public Integer visit(LeafNode node) {
        return 1;
    }

    @Override
    public Integer visit(InternalNode node) {
        return 1 + node.getLeftChild().accept(this) + node.getRightChild().accept(this);
    }
}
