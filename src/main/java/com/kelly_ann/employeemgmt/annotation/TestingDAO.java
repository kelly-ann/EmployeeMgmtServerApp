package com.kelly_ann.employeemgmt.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.inject.Qualifier;


//@Retention tells the JVM whether it should keep this attribute for use at runtime or compile-time-only (default).
//@Target tells Java where the attribute can be used/placed (i.e right above a method, class, field, etc.)
// it takes a comma-delimited list of all the types the attribute can be assigned to.
//@Qualified tells JVM that this annotation will be used to let the JVM know which class to 
//inject/use/wire to when the class's types are the same.

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER})
@Qualifier
public @interface TestingDAO {
	//no-op
}
