package algorithm.linkedlist;

public class FirstSharedNode {
    public static void main(String[] args) {
        ListNode headA = new ListNode(4);
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(8);
        ListNode a3 = new ListNode(4);
        ListNode a4 = new ListNode(5);
        headA.next = a1;
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        ListNode headB = new ListNode(5);
        ListNode b1 = new ListNode(0);
        ListNode b2 = new ListNode(1);
        headB.next = b1;
        b1.next = b2;
        b2.next = a2;
        System.out.println(getIntersectionNode(headA, headB));

    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode node = headA;
        int cntA =0;
        while(node != null){
            cntA++;
            node = node.next;
        }
        node = headB;
        int cntB =0;
        while(node != null){
            cntB++;
            node = node.next;
        }
        int step = 0;
        ListNode node2 = null;
        if(cntA >cntB) {
            step = cntA - cntB;
            node = headA;
            for(int i=0; i< step; i++){
                node = node.next;
            }
            node2 = headB;
        } else if(cntA < cntB) {
            step = cntB - cntA;
            node = headB;
            for(int i=0; i< step; i++){
                node = node.next;
            }
            node2=headA;
        } else{
            node = headA;
            node2 = headB;
        }

        while(node != null && node2 != null){
            if(node == node2) {
                return node;
            }
            node = node.next;
            node2 = node2.next;
        }
        return null;

    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
}
