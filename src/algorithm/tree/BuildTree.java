package algorithm.tree;

import java.util.HashMap;

/**
 * 核心是，前序的root节点后面全是它下面的左右节点
 * 中序中root节点左边的都是左边节点，右边的都是右边节点
 * 可计通过中序计算出root左右节点的个数，然后在前序中按个数找
 * 比如root左边有2个节点，右边有3个节点，则可用前序中向右找2个即为左边，向右边找3个即为右边节点
 * @Author zp
 * @create 2020/12/22 15:54
 */
public class BuildTree {
    public static void main(String[] args) {
//        int[] preorder = {1, 2, 4, 7, 3, 5, 6, 8};
//        int[] inorder = {4, 7, 2, 1, 5, 3, 8, 6};
        int[] preorder = {1, 2, 3};
        int[] inorder = {3, 2, 1};
        printTree(buildTree(preorder, inorder));
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            // 将中序数组反过来存储，
            // key为值，val为下标，后续计算左右两边节点个数用
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    public static TreeNode buildTree(int[] preorder, int preoderStart, int preorderEnd,
                                     int[] inorder, int inorderStart, int inorderEnd, HashMap<Integer, Integer> map) {
        if (preoderStart > preorderEnd) {
            return null;
        }
        // 根节点val
        int rootVal = preorder[preoderStart];
        // 新建根节点元素
        final TreeNode root = new TreeNode(rootVal);
        if (preoderStart == preorderEnd) {
            // 只有一个元素
            return root;
        } else {
            // 获取root节点的下标
            final Integer rootIndex = map.get(rootVal);
            // 计算左边节点的个数
            int leftNodesNum = rootIndex - inorderStart;
            int rightNodesNum = inorderEnd - rootIndex;
            // 将root左右两边的边界值传入递归函数中，可用实际数字来推具体的+1还是-1
            root.left = buildTree(preorder, preoderStart + 1, preoderStart + leftNodesNum,
                    inorder, inorderStart, rootIndex - 1, map);
            root.right = buildTree(preorder, preorderEnd - rightNodesNum + 1, preorderEnd,
                    inorder, rootIndex + 1, inorderEnd, map);
            return root;
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

    public static void printTree(TreeNode treeNode){
        System.out.println(treeNode.val);
        if(treeNode.left!= null || treeNode.right!= null){
            if(treeNode.left != null){
                printTree(treeNode.left);
            } else {
                System.out.println("null");
            }
            if(treeNode.right != null){
                printTree(treeNode.right);
            } else {
                System.out.println("null");
            }
        }

    }

}
