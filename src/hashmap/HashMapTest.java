package hashmap;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put("1","a");
        System.out.println(hashMap.get("1"));
        hashMap.size();
        ConcurrentHashMap<Object, Object> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("1","b");
        System.out.println(concurrentHashMap.get("1"));
        concurrentHashMap.size();
    }
}
