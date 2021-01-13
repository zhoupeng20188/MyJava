package algorithm.linkedlist;

/**
 * 反转链表
 *
 * @Author zp
 * @create 2021/1/13 16:45
 */
public class ReverseList {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        System.out.println(reverseList(listNode));
    }

    public static ListNode reverseList(ListNode head) {
        ListNode now = null;
        ListNode pre = null;
        ListNode next = null;
        while(head != null){
            now = head;
            next = now.next;
            // 修改当前节点和前一个节点的指针
            now.next = pre;
            pre = now;
            head = next;
        }
        return pre;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
