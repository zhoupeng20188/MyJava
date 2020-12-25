package algorithm.tree;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * 序列化与反序列化二叉树
 * @Author zp
 * @create 2020/12/25 16:17
 */
public class CodecTree {
    public static void main(String[] args) {
        final TreeNode root = new TreeNode(1);
        final TreeNode left1 = new TreeNode(2);
        final TreeNode right1 = new TreeNode(3);
        final TreeNode left2 = new TreeNode(4);
        final TreeNode right2 = new TreeNode(5);
        root.left = left1;
        root.right = right1;
        left1.left = left2;
        left1.right = right2;
        serialize(root);
        System.out.println(str);
        TreeNode t = deserialize(str);
        System.out.println(t);
    }

    static String str = "";
    static char[] cArr;
    static int index = 0;

    // Encodes a tree to a single string.
    public static void serialize(TreeNode root) {
        if (root == null) {
            str += "$";
        } else {
            str += root.val;
            serialize(root.left);
            serialize(root.right);
        }

    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        cArr = data.toCharArray();
        return deserialize();
    }

    public static TreeNode deserialize() {
        TreeNode node =null;
        char[] ch = {cArr[index]};
        String s = new String(ch);
        if(!s.equals("$")){
            node = new TreeNode(Integer.parseInt(s));
            index++;
            node.left = deserialize();
            index++;
            node.right = deserialize();
        }

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
