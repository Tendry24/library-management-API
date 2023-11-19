package org.libraryManagement.firstAnnotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MyFirstAnnotation {
    String value() default "first annotation";
    int count() default 1;
}
