package algorithm.lru;

/**
 * @Author zp
 * @create 2020/10/22 17:07
 */
public class LruTest {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(10);
        lruCache.put(10,13);
        lruCache.put(3,17);
        lruCache.put(6,11);
        lruCache.put(10,5);
        lruCache.put(9,10);
        System.out.println(lruCache.get(13));
        lruCache.put(2,19);
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(3));
        lruCache.put(5,25);
        System.out.println(lruCache.get(8));
        lruCache.put(9,22);
        lruCache.put(5,5);
        lruCache.put(1,30);
        System.out.println(lruCache.get(11));
        lruCache.put(9,12);
        System.out.println(lruCache.get(7));
        System.out.println(lruCache.get(5));
        System.out.println(lruCache.get(8));
        System.out.println(lruCache.get(9));
        lruCache.put(4,30);
        lruCache.put(9,3);
        System.out.println(lruCache.get(9));
        System.out.println(lruCache.get(10));
        System.out.println(lruCache.get(10));
        lruCache.put(6,14);
        lruCache.put(3,1);
        System.out.println(lruCache.get(3));
        lruCache.put(10,11);
        System.out.println(lruCache.get(8));
        lruCache.put(2,14);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(5));
        System.out.println(lruCache.get(4));
        lruCache.put(11,4);
        lruCache.put(12,24);
        lruCache.put(5,18);
        System.out.println(lruCache.get(13));
        lruCache.put(7,23);
        System.out.println(lruCache.get(8));
        System.out.println(lruCache.get(12));
        lruCache.put(3,27);
        lruCache.put(2,12);
        System.out.println(lruCache.get(5));
        lruCache.put(2,9);
        lruCache.put(13,4);
        lruCache.put(8,18);
        lruCache.put(1,7);
        System.out.println(lruCache.get(6));
//        lruCache.put(3,3);
//        lruCache.put(1,1);
//        lruCache.put(4,1);
//        System.out.println(lruCache.get(3));
//        System.out.println(lruCache.get(4));
    }
}
