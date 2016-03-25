package com.kelly_ann.employeemgmt.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


//@Retention tells the JVM whether it should keep this attribute for use at runtime or compile-time-only (default).
//@Target tells Java where the attribute can be used/placed (i.e right above a method, class, field, etc.
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.TYPE})
public @interface TestingDAO {

}
