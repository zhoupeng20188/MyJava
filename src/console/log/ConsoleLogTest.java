package console.log;

import java.io.PrintStream;

/**
 * @Author zp
 * @create 2020/12/8 16:18
 */
public class ConsoleLogTest {
    public static void main(String[] args) {
        //备份原有输出流
        PrintStream old = System.out;
        ConsoleStream newStream= new ConsoleStream(old);
        //设置新的输出流
        System.setOut(new PrintStream(newStream));
        System.out.println("abcde");
        System.out.println("abcde2");
        System.out.println("abcde3");
        System.out.print(LogStore.getContent());

//        ByteArrayOutputStream baoStream = new ByteArrayOutputStream(1024);
//        PrintStream cacheStream = new PrintStream(baoStream);//临时输出
//        PrintStream oldStream = System.out;//缓存系统输出
//        System.setOut(cacheStream);
//        System.out.println("abc");//不会打印到控制台
//        System.out.println("abc2");//不会打印到控制台
//        String result = baoStream.toString();//存放控制台输出的字符串
//        System.setOut(oldStream);//还原到系统输出
//        System.out.print(result);
    }
}
