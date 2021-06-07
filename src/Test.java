import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("sdfs");
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(1,2);
        linkedList.get(0);
        linkedList.remove(1);
        HashMap hashMap = new HashMap();
        hashMap.put("1","a");
        int[] a = {1,2,3};
        int[] b = a;
        System.out.println(a==b);
        a[0] = 4;
        System.out.println(a==b);
        System.out.println(b[0]);
    }
}
