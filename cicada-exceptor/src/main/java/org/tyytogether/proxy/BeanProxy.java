package org.tyytogether.proxy;

import org.tyytogether.annotation.CicadaBean;
import org.tyytogether.annotation.ExceptionInfo;
import org.tyytogether.exception.CicadaException;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class BeanProxy implements InvocationHandler {
    String nameSpace;

    public <T> BeanProxy(Class<T> interfaceClass) {
        this.nameSpace = interfaceClass.getAnnotation(CicadaBean.class).namespace();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        ExceptionInfo exceptionInfo = method.getAnnotation(ExceptionInfo.class);
        return new CicadaException(nameSpace, exceptionInfo.errCode(), exceptionInfo.errMessage());
    }
}
