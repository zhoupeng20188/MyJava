package algorithm.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * 采用hashmap加双向链表实现
 * hashmap保证get方法为O(1)
 * 双向链表保证put方法为O(1)
 * @Author zp
 * @create 2020/10/22 17:08
 */
public class LRUCache2 {
    class DLinkedNode {
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
    private DLinkedNode head, tail;
    private int size;
    private int capacity;

    public LRUCache2(int capacity) {
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
        // key存在时，移动到链表头部
        moveToHead(dLinkedNode);
        return dLinkedNode.value;
    }

    public void put(int key, int value) {
        DLinkedNode dLinkedNode = map.get(key);
        if (dLinkedNode != null) {
            // 如果key存在，则更新
            dLinkedNode.value = value;
            // 移动到链表头部
            moveToHead(dLinkedNode);
        } else {
            // 如果key不存在，则插入
            DLinkedNode dLinkedNode1 = new DLinkedNode(key, value);
            map.put(key,dLinkedNode1);
            size++;
            if(size > capacity){
                // 容量满时
                // 删除map中的元素
                map.remove(tail.prev.key);
                // 删除链表尾部节点
                removeTailNode();
                size--;
            }
            // 将新元素插入到链表头部
            insertHead(dLinkedNode1);
        }
    }

    private void moveToHead(DLinkedNode node) {
        // 移动到head时，还需要将node原来的前后节点的指针改过来
        DLinkedNode nodePrev = node.prev;
        DLinkedNode nodeNext = node.next;
        if(nodePrev != head){
            // 元素不在头部时才移动
            DLinkedNode headNextTmp = head.next;
            head.next = node;
            node.next = headNextTmp;
            headNextTmp.prev = node;
            node.prev = head;
            // 修改node原前节点的next指针
            nodePrev.next = nodeNext;
            // 修改node后后节点的pre指针
            nodeNext.prev = nodePrev;
        }
    }

    /**
     * 删除链表尾部节点
     */
    private void removeTailNode() {
        DLinkedNode prevTmp = tail.prev;
        DLinkedNode prevPrevTmp = prevTmp.prev;
        prevPrevTmp.next = tail;
        tail.prev = prevPrevTmp;
    }

    /**
     * 插入元素到链表头部
     */
    private void insertHead(DLinkedNode node) {
        DLinkedNode nextTmp = head.next;
        head.next = node;
        node.next = nextTmp;
        nextTmp.prev = node;
        node.prev = head;
    }
}
