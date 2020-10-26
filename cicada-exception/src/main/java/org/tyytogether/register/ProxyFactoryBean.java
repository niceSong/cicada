package org.tyytogether.register;

import org.springframework.beans.factory.FactoryBean;
import org.tyytogether.proxy.BeanProxy;

import java.lang.reflect.Proxy;

public class ProxyFactoryBean<T> implements FactoryBean<T> {

    Class<T> interfaceClass;

    @Override
    public T getObject() throws Exception {
        BeanProxy beanProxy = new BeanProxy(interfaceClass);
        return (T)Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[]{interfaceClass}, beanProxy);
    }

    @Override
    public Class<?> getObjectType() {
        return interfaceClass;
    }

    public Class<T> getInterfaceClass() {
        return interfaceClass;
    }

    public void setInterfaceClass(Class<T> interfaceClass) {
        this.interfaceClass = interfaceClass;
    }
}
