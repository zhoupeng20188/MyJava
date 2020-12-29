package algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author zp
 * @create 2020/12/29 11:08
 */
public class FindMaxK {
    public static void main(String[] args) {
        final TreeNode root = new TreeNode(3);
        final TreeNode left1 = new TreeNode(1);
        final TreeNode right1 = new TreeNode(4);
//        final TreeNode left2 = new TreeNode(1);
        final TreeNode right2 = new TreeNode(2);
        root.left = left1;
        root.right = right1;
//        left1.left = left2;
        left1.right = right2;
        System.out.println(kthLargest(root, 3));
    }

    public static int kthLargest(TreeNode root, int k) {
        if(root == null) return 0;
        inorder(root);
        int size = result.size();
        if(size > 0) {
            int val = 0;
            int i = size -1;
           while(k>0){
                val = result.get(i).val;
                k--;
                i--;
            }
            return val;
        }
        return 0;
    }
//    static int cnt=0;
    static List<TreeNode> result = new ArrayList<>();
    public static TreeNode inorder(TreeNode node){
        if(node == null) return null;

        if(node.left !=null) inorder(node.left);

        result.add(node);

        if(node.right !=null) inorder(node.right);

        return null;
    }

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
