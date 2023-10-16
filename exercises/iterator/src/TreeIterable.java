import java.util.Iterator;
import java.util.Stack;

public class TreeIterable implements Iterable<TreeNode> {
    private TreeNode root;

    public TreeIterable(TreeNode root) {
        this.root = root;
    }

    @Override
    public Iterator<TreeNode> iterator() {
        return new PreOrderIterator(root);
    }

    private class PreOrderIterator implements Iterator<TreeNode> {
        private Stack<TreeNode> stack;

        public PreOrderIterator(TreeNode root) {
            stack = new Stack<>();
            if (root != null) {
                stack.push(root);
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public TreeNode next() {
            if (!hasNext()) {
                return null;
            }
            TreeNode node = stack.pop();
            if (node instanceof InternalNode) {
                InternalNode internalNode = (InternalNode) node;
                if (internalNode.getRight() != null) {
                    stack.push(internalNode.getRight());
                }
                if (internalNode.getLeft() != null) {
                    stack.push(internalNode.getLeft());
                }
            }
            return node;
        }
    }
}
