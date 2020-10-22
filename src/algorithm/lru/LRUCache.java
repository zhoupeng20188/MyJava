package algorithm.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author zp
 * @create 2020/10/22 17:08
 */
public class LRUCache {
    class DLinkedNode{
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode() {
        }
        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    private Map<Integer, DLinkedNode> map = new HashMap<>();
    private DLinkedNode head,tail;
    private int size;
    private int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode dLinkedNode = map.get(key);
        if(dLinkedNode == null){
            return -1;
        }
        // 如果key存在，则移动到链表的末尾
        moveToTail(dLinkedNode);
        return dLinkedNode.value;
    }

    private void addToTail(DLinkedNode node) {
        DLinkedNode prev = tail.prev;
        prev.next = node;
        node.prev = prev;
        tail.prev = node;
        node.next = tail;
    }

    private void moveToTail(DLinkedNode node) {
        DLinkedNode prev = node.prev;
        DLinkedNode next = node.next;
        DLinkedNode tailPrev = tail.prev;
        if(tailPrev != node){
            // 该node不在末尾时才移动
            prev.next = next;
            next.prev = prev;
            tailPrev.next = node;
            node.prev = tailPrev;
            node.next = tail;
            tail.prev = node;
        }

    }

    public void put(int key, int value) {
        DLinkedNode dLinkedNode = map.get(key);
        if(dLinkedNode != null){
            // 如果key存在，则更新
            dLinkedNode.value = value;
            // 移动到链表末尾
            moveToTail(dLinkedNode);
        } else {
            // 如果key不存在，则插入
            DLinkedNode dLinkedNode1 = new DLinkedNode(key, value);
            // 放入hash表中
            map.put(key, dLinkedNode1);
            size++;
            if(size > capacity){
                // 如果size超出容量，则删除链表的头部节点
                removeHead();
                size--;
            }
            // 加到链表末尾
            addToTail(dLinkedNode1);
        }
    }

    private void removeHead() {
        DLinkedNode next = head.next;
        // 删除hash表中其对应的key
        map.remove(next.key);
        DLinkedNode nextNext = head.next.next;
        if(nextNext == null){
            // 表明只有1个元素，删除后变成初始状态
            head.next = tail;
            tail.prev = head;
        } else{
            head.next = nextNext;
            nextNext.prev = head;
        }
    }
}
