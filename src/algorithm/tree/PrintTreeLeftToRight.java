package algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 每次打印当前节点后，用一个队列记录该节点的左节点和右节点，再输出队列中的第一个节点。
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
        queue.add(root.val);
        print(root, queue);


    }

    public static void print(TreeNode root, Queue<Integer> queue) {
        if (root != null) {
            System.out.println(queue.poll());
            if (root.left != null){
                queue.add(root.left.val);
                queue.add(root.right.val);
                print(root.left, queue);
            }
            if(root.right != null){
                queue.add(root.left.val);
                queue.add(root.right.val);
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
