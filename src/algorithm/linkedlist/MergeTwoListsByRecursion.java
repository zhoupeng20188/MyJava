package algorithm.linkedlist;

/**
 * 递归解法
 */
public class MergeTwoListsByRecursion {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;


        ListNode m1 = new ListNode(1);
        ListNode m2 = new ListNode(3);
        ListNode m3 = new ListNode(4);

        m1.next = m2;
        m2.next = m3;

        ListNode node = mergeTwoLists(n1, m1);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode root = null;

        int v1 = l1.val;
        int v2 = l2.val;
        if (v1 < v2) {
            root = l1;
            root.next = mergeTwoLists(l1.next, l2);
        } else {
            root = l2;
            root.next = mergeTwoLists(l1, l2.next);
        }

        return root;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
