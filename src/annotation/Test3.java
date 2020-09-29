package annotation;

import java.lang.reflect.Field;

/**
 * @Author zp
 * @create 2020/9/29 16:51
 */
public class Test3 {
    public static void main(String[] args) {
        DefaultBeanFactory defaultBeanFactory = new DefaultBeanFactory();
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
                    defaultBeanFactory.registerBean("testController", testController);
                    System.out.println(testController.getTestService());
                    System.out.println(defaultBeanFactory.getBean("testController"));
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
