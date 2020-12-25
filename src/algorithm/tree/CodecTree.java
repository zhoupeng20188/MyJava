package algorithm.tree;

/**
 * @Author zp
 * @create 2020/12/25 16:17
 */
public class CodecTree {
    public static void main(String[] args) {

    }

    static String str = "";
    static char[] cArr;

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if (root == null) {
            return str += "$";
        }
        str += root.val;
        return serialize(root.left) + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        int i = 0;
        cArr = data.toCharArray();
        return deserialize(null, 0);
    }

    public static TreeNode deserialize(TreeNode node, int i) {
        node = new TreeNode();
        node.val = new String(cArr[i]);
        deserialize(node.left, i + 1);
        deserialize(node.right, i + 1);
        return node;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
