package stringbuilder;

/**
 * @Author zhoupeng
 * @Date 2020-05-09 12:05
 */
public class Main {
    public static void main(String[] args) {
        long at = System.currentTimeMillis();
        String a= "dff";
        for (int i = 0; i < 1000; i++) {
            a+=i;
        }
        System.out.println(a);
        long ae = System.currentTimeMillis();
        System.out.println("string+操作耗时:" + (ae-at));
        long bt = System.currentTimeMillis();

        StringBuilder sb = new StringBuilder();
        sb.append("dff");
        for (int i = 0; i < 1000; i++) {
            sb.append(i);
        }
        System.out.println(sb.toString());
        long be = System.currentTimeMillis();
        System.out.println("stringbuilder操作耗时:" + (be-bt));
    }
}
