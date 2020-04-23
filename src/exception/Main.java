package exception;

/**
 * @Author zhoupeng
 * @Date 2020-04-10 17:41
 */
public class Main {
    public static void main(String[] args) {
        String a = null;
        try {
            a.substring(0);
        } catch (NullPointerException e) {
            System.out.println("NullPointerException");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Exception");
            e.printStackTrace();
        }
    }
}
