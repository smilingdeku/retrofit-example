package org.example.retrofit.annotation;

import org.example.retrofit.config.retrofit.RetrofitBeanRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author linzhaoming
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(RetrofitBeanRegistrar.class)
public @interface EnableRetrofit {

    String[] basePackages() default {};

    Class<?>[] basePackageClasses() default {};

}
