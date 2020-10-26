package algorithm.two.number.add;

/**
 * 两数相加，两个链表，每个元素代表一个数的某一位上的值
 * 逆序排列。如果两个链表中数字位数不相同，则补0
 * @Author zp
 * @create 2020/10/26 10:36
 */
public class TwoNumberAdd {
    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        ListNode result = addTwoNumbers(l1, l2);
        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode tail = null;
        int nextVal = 0;
        while(l1 != null || l2 != null){
            int l1Val = l1 == null?0:l1.val;
            int l2Val = l2 == null?0:l2.val;
            int val = l1Val + l2Val + nextVal;
            // 该位的计算结果
            int thisVal = val % 10;
            // 进位
            nextVal = val / 10;

            if(tail == null){
                result = new ListNode(thisVal);
                tail =result;
            } else {
                tail.next = new ListNode(thisVal);
                tail =tail.next;
            }
            l1 = l1==null?null:l1.next;
            l2 = l2==null?null:l2.next;
        }
        if(nextVal > 0) {
            // 处理最后一次的进位
            tail.next = new ListNode(nextVal);
        }
        return result;
    }
}
