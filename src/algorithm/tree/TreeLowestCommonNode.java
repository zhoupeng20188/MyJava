package algorithm.tree;

import java.util.LinkedList;

/**
 * 二叉树的公共祖先
 *
 * @Author zp
 * @create 2020/12/31 10:22
 */
public class TreeLowestCommonNode {
    public static void main(String[] args) {
        final TreeNode root = new TreeNode(3);
        final TreeNode left1 = new TreeNode(5);
        final TreeNode right1 = new TreeNode(1);
        final TreeNode left2 = new TreeNode(6);
        final TreeNode right2 = new TreeNode(2);
        final TreeNode left3 = new TreeNode(7);
        final TreeNode right3 = new TreeNode(4);
        final TreeNode left4 = new TreeNode(0);
        final TreeNode right4 = new TreeNode(8);
        root.left = left1;
        root.right = right1;
        left1.left = left2;
        left1.right = right2;
        right2.left = left3;
        right2.right = right3;
        right1.left = left4;
        right1.right = right4;
        final TreeNode treeNode = lowestCommonAncestor(root, left1, right1);
        System.out.println(treeNode);

    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        getTargetNodePath(root, p, 1);
        isBreak = false;
        getTargetNodePath(root, q, 2);
        int size1 = list1.size();
        int size2 = list2.size();
        // System.out.println("size1="+size1 + ",size2="+size2);
        int k = 0;
        // 求两个链表的第一个共通元素
        if(size1 >= size2) {
            k = size1 - size2;
            // 先走k步
            for(int i=0; i< k; i++){
                list1.removeLast();
            }
        } else {
            k = size2 - size1;
            // 先走k步
            for(int i=0; i< k; i++){
                list2.removeLast();
            }
        }
        // 求两个链表的第一个共通元素（树是反向的链表）
        while(list1.size() > 0 && list2.size() > 0){
            TreeNode node1 = list1.pollLast();
            TreeNode node2 = list2.pollLast();
            if(node1 == node2) return node1;
        }

        return null;


    }

    // 保存到p节点的路径
    static LinkedList<TreeNode> list1 = new LinkedList<>();
    // 保存到q节点的路径
    static LinkedList<TreeNode> list2 = new LinkedList<>();
    static boolean isBreak = false;

    public static void getTargetNodePath(TreeNode root, TreeNode node, int flag) {
        if (isBreak) return;
        // 前序遍历
        if (root != null) {
            if (root.val != node.val) {
                if (flag == 1) {
                    list1.addLast(root);
                } else {
                    list2.addLast(root);
                    }

                getTargetNodePath(root.left, node, flag);
                getTargetNodePath(root.right, node, flag);
                if (!isBreak) {
                    if (flag == 1) {
                        list1.removeLast();
                    } else {
                        list2.removeLast();
                    }
                }


            } else {
                if (flag == 1) {
                    list1.addLast(root);
                } else {
                    list2.addLast(root);
                }
                isBreak = true;
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
