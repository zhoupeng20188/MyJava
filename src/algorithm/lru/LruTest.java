package algorithm.lru;

/**
 * @Author zp
 * @create 2020/10/22 17:07
 */
public class LruTest {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.put(3,3);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        lruCache.put(4,4);
        System.out.println(lruCache.get(2));
    }
}
