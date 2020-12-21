package algorithm.linkedlist;

import java.util.Stack;

/**
 * 反向打印链表
 *
 * @Author zp
 * @create 2020/12/21 12:58
 */
public class ReversePrint {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        System.out.println(reversePrint(listNode));
    }

    public static int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode next = head;
        while (next != null) {
            stack.push(next.val);
            next = next.next;
        }
        int size = stack.size();
        int[] returnArray = new int[size];
        for (int i = 0; i < size; i++) {
            returnArray[i] = stack.pop();
        }
        return returnArray;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
