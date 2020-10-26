package org.tyytogether.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface ExceptionInfo {
    int errCode() default 0;
    String errMessage() default "";
}
