package finalclass;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        // Final类为不可变类
        // Final类中只有get方法，没有set方法
        // 如果需要改变值，直接返回一个新的对象
        // Final类无法被继承，本质上是为了不让修改
        // Final类中所有属性都是final
        // 线程安全
        // 不可变类可以被共享，如果定义一个常量final a3=new FinalClassTest，
        // 之后使用a3则都会用这一个对象，不会重复创建对象
        FinalClassTest finalClassTest = new FinalClassTest(3, 4);
        System.out.println(finalClassTest);
        FinalClassTest pingfang = finalClassTest.pingfang();
        System.out.println(pingfang);
        FinalClassTest f2 = FinalClassTest.f1;
        FinalClassTest f3 = new FinalClassTest(10, 20);
        FinalClassTest f4 = FinalClassTest.f1;
        System.out.println(f2 == f3);
        System.out.println(f2 == f4);
        String s = new String("123");
        BigInteger b1;
        BigInteger one = BigInteger.ONE;
    }
}
