package algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
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
        Queue<Integer> queue = new LinkedList<>();
        print(root, queue);


    }

    public static void print(TreeNode root, Queue<Integer> queue) {
        if (root != null) {
            queue.add(root.val);
            System.out.println(queue.poll());
            if (root.left != null){
                print(root.left, queue);
            }
            if(root.left != null){
                print(root.right, queue);
            }
        }
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
