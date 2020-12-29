package algorithm.linkedlist;

/**
 * 非递归解法
 */
public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(4);
        n1.next =n2;
        n2.next =n3;


        ListNode m1 = new ListNode(1);
        ListNode m2 = new ListNode(3);
        ListNode m3 = new ListNode(4);

        m1.next = m2;
        m2.next = m3;

        ListNode node = mergeTwoLists(n1, m1);
        while(node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode tail = null;
        // 记录第一个节点，如果只用一个变量，则会返回尾节点
        ListNode head = null;
        ListNode node = null;
        while(l1 != null && l2 != null) {
            int v1 = l1.val;
            int v2 = l2.val;
            if(v1 < v2) {
                node = l1;
                l1 = l1.next;
            } else {
                node = l2;
                l2 = l2.next;
            }
            if(head == null) {
                head = node;
                tail = head;
            } else {
                tail.next = node;
                tail = tail.next;
            }
        }
        // 最后可能还有剩余
        if(l1 != null) {
            tail.next = l1;
        }
        if(l2 != null) {
            tail.next = l2;
        }
        return head;
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
