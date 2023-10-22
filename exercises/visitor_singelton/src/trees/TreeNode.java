package trees;

import animals.AnimalVisitor;

public interface TreeNode {
    int getId();
    <T> T accept(TreeVisitor<T> visitor);
}
