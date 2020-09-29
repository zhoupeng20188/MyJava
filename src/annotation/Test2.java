package annotation;

import java.lang.reflect.Field;

/**
 * @Author zp
 * @create 2020/9/29 14:28
 */
public class Test2 {
    public static void main(String[] args) {
        TestController testController = new TestController();
        Class<? extends TestController> aClass = testController.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field field : declaredFields) {
            Autowired annotation = field.getAnnotation(Autowired.class);
            if(annotation != null){
                Class<?> type = field.getType();
                field.setAccessible(true);
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

    }
}
