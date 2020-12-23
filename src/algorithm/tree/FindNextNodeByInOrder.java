package algorithm.tree;

/**
 * 中序遍历，查找树的下一个节点
 *
 * @Author zp
 * @create 2020/12/23 8:48
 */
public class FindNextNodeByInOrder {
    public static void main(String[] args) {

    }

    public static void findNextNodeByInOrder(TreeNode treeNode) {
        if (treeNode != null) {
            if (treeNode.right != null) {
                final TreeNode right = treeNode.right;
                if (right.left != null) {
                    // 第一种情况，节点有右子树，则右子树的第一个左节点即为下一个节点
                    System.out.println(right.left.val);
                }
            } else if (treeNode.parent != null) {
                TreeNode parent = treeNode.parent;
                TreeNode current = treeNode;
                if (parent != null && parent.right == current) {
                    // 第三种情况，如果这个节点是父节点的右节点，则需要往上找
                    // 直到找到一个为它的父节点的左节点为止，这个左节点的父节点即为目标节点
                    current = current.parent;
                    parent = current.parent;
                }
                // 第二种情况，如果这个节点是左节点，则下一个节点为它的父节点
                System.out.println(treeNode.parent);
            }
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode parent;

        TreeNode(int x) {
            val = x;
        }
    }
}
