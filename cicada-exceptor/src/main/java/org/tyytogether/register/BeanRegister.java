package org.tyytogether.register;

import lombok.SneakyThrows;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.tyytogether.annotation.CicadaScan;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BeanRegister implements ImportBeanDefinitionRegistrar {

    private ApplicationContext ctx;

    @SneakyThrows
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        ScanProvider provider = new ScanProvider();
        Map<String, Object> annotationAttr = importingClassMetadata.getAnnotationAttributes(CicadaScan.class.getCanonicalName());
        assert annotationAttr != null;
        Set<BeanDefinition> beanDefinitionSet = new HashSet<>();
        annotationAttr.forEach((key, value)-> {
            beanDefinitionSet.addAll(provider.findCandidateComponents((String) value));
        });
        beanDefinitionSet.forEach(beanDefinition -> {
            BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(beanDefinition.getBeanClassName());
            GenericBeanDefinition definition = (GenericBeanDefinition) builder.getRawBeanDefinition();
            definition.getPropertyValues().add("interfaceClass", definition.getBeanClassName());
            definition.setBeanClass(ProxyFactoryBean.class);
            definition.setAutowireMode(GenericBeanDefinition.AUTOWIRE_BY_TYPE);
            registry.registerBeanDefinition("cicada "+beanDefinition.getBeanClassName(), definition);
        });
    }
}
