package trees;

public interface TreeVisitor<T> {
    T visit(LeafNode node);
    T visit(InternalNode node);
}
