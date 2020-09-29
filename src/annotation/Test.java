package annotation;

import java.lang.reflect.Field;

/**
 * @Author zp
 * @create 2020/9/29 14:28
 */
public class Test {
    public static void main(String[] args) {
        TestController testController = new TestController();
        Class<? extends TestController> aClass = testController.getClass();
        Field field = null;
        try {
            field = aClass.getDeclaredField("testService");
            field.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        Class<?> type = field.getType();
        System.out.println(type);
        try {
            Object o = type.newInstance();
            field.set(testController, o);
            System.out.println(testController.getTestService());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
