package com.jersey.spring.rest.async;


import javax.ws.rs.NameBinding;
import java.lang.annotation.*;

@NameBinding
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PoweredBy {
	String value() default "";
}
