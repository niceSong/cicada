package org.tyytogether.annotation;

import org.springframework.context.annotation.Import;
import org.tyytogether.register.BeanRegister;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(BeanRegister.class)
public @interface CicadaScan {
}
