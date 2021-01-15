package hashmap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * HashMap,LinkedHashMap,TreeMap有序性测试
 * 结论：HashMap和TreeMap是无序的（但TreeMap会根据key来排序），LinkedHashMap是有序的
 */
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


        Map<String, String> map = new HashMap<String, String>();
        map.put("abc23", "1");
        map.put("baavdc23", "2");
        map.put("cbbd32", "3");
        map.put("dsdsf232", "4");

        System.out.print("HashMap:");
        for(String key : map.keySet()) {
            System.out.print(map.get(key) + " ");
        }

        Map<String, String> linkedMap = new LinkedHashMap<String, String>();
        linkedMap.put("baavdc23", "1");
        linkedMap.put("abc23", "2");
        linkedMap.put("cbbd32", "3");
        linkedMap.put("dsdsf232", "4");

        System.out.print("LinkedHashMap:");
        for(String key : linkedMap.keySet()) {
            System.out.print(linkedMap.get(key) + " ");
        }

        Map<String, String> treeMap = new TreeMap<String, String>();
        treeMap.put("baavdc23", "1");
        treeMap.put("abc23", "2");
        treeMap.put("cbbd32", "3");
        treeMap.put("dsdsf232", "4");

        System.out.print("TreeMap:");
        for(String key : treeMap.keySet()) {
            System.out.print(treeMap.get(key) + " ");
        }

    }
}
