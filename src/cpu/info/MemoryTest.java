package cpu.info;

/**
 * @Author zp
 * @create 2020/12/8 15:32
 */
public class MemoryTest {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().totalMemory());
        System.out.println(Runtime.getRuntime().freeMemory());
        System.out.println(Runtime.getRuntime().maxMemory());
    }
}
