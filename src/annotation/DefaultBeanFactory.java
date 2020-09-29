package annotation;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author zp
 * @create 2020/9/29 16:48
 */
public class DefaultBeanFactory implements BeanFactory {
    private static final ConcurrentHashMap<String,Object> beanMap = new ConcurrentHashMap<>(64);
    @Override
    public Object getBean(String beanName) {
        return beanMap.get(beanName);
    }

    @Override
    public void registerBean(String beanName, Object bean) {
        beanMap.put(beanName, bean);
    }
}
