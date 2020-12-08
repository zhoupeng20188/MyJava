package console.log;

/**
 * @Author zp
 * @create 2020/12/8 16:47
 */
public class LogStore {
    private static StringBuilder sb = new StringBuilder();
    public static String getContent(){
        return sb.toString();
    }

    public static void addContent(String s){
        clear();
        sb.append(s);
    }

    public static void clear(){
        sb.delete(0, sb.length());
    }
}
