package org.tyytogetheyy.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.tyytogetheyy.exception.TestException;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class TestService implements ApplicationContextAware {

    @Autowired
    TestException testException;

    ApplicationContext ctx;

    @PostConstruct
    void printBean(){
        ctx.getType("cicada org.tyytogetheyy.exception.TestException");
        List<String> beanNames = Stream.of(ctx.getBeanDefinitionNames()).collect(Collectors.toList());
        beanNames.forEach(it-> {
            System.out.println("beanName:"+it);
        });
    }

    public void testCicada(){
        System.out.println("test");
        throw testException.fuckException("You throw cicada exception successfully");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx = applicationContext;
    }
}
