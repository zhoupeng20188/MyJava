package lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author zp
 * @create 2019/10/15 9:06
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int CACHE_SIZE;

    public LRUCache(int initialCapacity) {
        // 设置hashmap的初始大小，最后个true指的是让linkedHashMap按照访问顺序来排序，最近访问的放在头，最老访问的放在尾
        super((int) Math.ceil(initialCapacity / 0.75) + 1, 0.75f, true);
        CACHE_SIZE = initialCapacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        // 当map中的数据量大于指定的缓存个数时，就自动删除最老的数据
        return size() > CACHE_SIZE;
    }
}
