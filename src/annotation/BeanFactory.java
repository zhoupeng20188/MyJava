package annotation;

import javafx.beans.value.ObservableObjectValue;

/**
 * @Author zp
 * @create 2020/9/29 16:47
 */
public interface BeanFactory {
    public Object getBean(String  beanName);
    public void  registerBean(String beanName, Object bean);
}
