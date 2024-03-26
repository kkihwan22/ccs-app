package org.ccs.app.core.share.support;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringBeanSupport implements ApplicationContextAware {
    private static ApplicationContext ac;

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        this.ac = context;
    }

    public static <T> T getBean(Class<T> beanClass) {
        return ac.getBean(beanClass);
    }
}
