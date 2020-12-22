package algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 用一个队列记录节点，每次打印队列中的节点，并把当前节点的左右节点入队。
 *
 * @Author zp
 * @create 2020/12/22 17:21
 */
public class PrintTreeLeftToRight {
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
        levelOrder(root);


    }

    public static int[] levelOrder(TreeNode root) {
        if(root == null) return new int[0];
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if(node.left != null) {
                queue.add(node.left);
            }
            if(node.right != null) {
                queue.add(node.right);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
            System.out.println(result[i]);
        }
        return result;
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
