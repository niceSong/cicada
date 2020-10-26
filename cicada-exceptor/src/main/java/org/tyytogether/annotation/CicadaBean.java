package org.tyytogether.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface CicadaBean {
    String namespace() default "default";
}
