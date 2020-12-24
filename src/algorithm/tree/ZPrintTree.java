package algorithm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ZPrintTree {
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

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        stack1.push(root);
        int nowPrint =1;
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            if(nowPrint == 1) {
                TreeNode node = stack1.pop();
                list.add(node.val);

                if(node.left != null) {
                    stack2.push(node.left);
                }
                if(node.right != null) {
                    stack2.push(node.right);
                }

            } else {
                TreeNode node = stack2.pop();
                list.add(node.val);

                if(node.right != null) {
                    stack1.push(node.right);
                }
                if(node.left != null) {
                    stack1.push(node.left);
                }

            }

            if(stack1.isEmpty() && nowPrint == 1){
                if(!list.isEmpty()) result.add(list);
                list = new ArrayList<>();
                nowPrint =2;
            }

            if(stack2.isEmpty() && nowPrint == 2){
                if(!list.isEmpty()) result.add(list);
                list = new ArrayList<>();
                nowPrint =1;
            }
        }
        return result;
    }

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
