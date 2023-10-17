import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public interface TreeNode {
    int getID();
    default Iterator<TreeNode> orderedIterator() {
        Iterator<TreeNode> iterator = new TreeIterable(this).iterator();
        List<TreeNode> list = new ArrayList<>();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        list.sort(Comparator.comparingInt(TreeNode::getID));
        return list.iterator();
    }
}
