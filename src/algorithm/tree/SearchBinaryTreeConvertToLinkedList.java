package algorithm.tree;

/**
 * @Author zp
 * @create 2020/12/25 15:12
 */
public class SearchBinaryTreeConvertToLinkedList {
    public static void main(String[] args) {
        final Node root = new Node(4);
        final Node left1 = new Node(2);
        final Node right1 = new Node(5);
        final Node left2 = new Node(1);
        final Node right2 = new Node(3);
        root.left = left1;
        root.right = right1;
        left1.left = left2;
        left1.right = right2;
        final Node node = treeToDoublyList(root);
        System.out.println(node);
    }

    public static Node treeToDoublyList(Node root) {
        if(root == null) return null;
        treeToDoublyList2(root);
        // 由于链表第一个节点是尾节点，所以取得头节点返回
        Node result = lastSortedLinkedList;
        if(result == null) return null;
        while(result.left != null){
            result = result.left;
        }
        return result;

    }

    static Node lastSortedLinkedList = new Node();

    public static void treeToDoublyList2(Node node) {
        if(node == null) return;
        if(node.left != null) {
            // 左子树转换
            treeToDoublyList2(node.left);
        }

        // 修改左右指针
        node.left = lastSortedLinkedList;
        if(lastSortedLinkedList != null) lastSortedLinkedList.right = node;

        lastSortedLinkedList = node;

        if(node.right != null) {
            // 右子树转换
            treeToDoublyList2(node.right);
        }
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}
