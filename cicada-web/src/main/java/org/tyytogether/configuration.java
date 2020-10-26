package org.tyytogether;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.tyytogether.handler.ExceptionAdvance;

@Configuration
public class configuration {
    @Bean
    @ConditionalOnMissingBean
    ExceptionAdvance exceptionAdvance(){
        return new ExceptionAdvance();
    }
}
