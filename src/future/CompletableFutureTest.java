package future;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
 * 普通的future的get方法会阻塞，而CompletableFuture可以在执行完成时回调
 * @Author zp
 * @create 2020/10/27 9:19
 */
public class CompletableFutureTest {
    public static void main(String[] args) throws IOException {
        CompletableFuture.supplyAsync(()->{
            try {
                System.out.println("i will sleep 3s");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "sdfsdf";
        }).thenAccept((result)->{
            System.out.println("i am done!!! result=" + result);
        });
        System.in.read();
    }
}
