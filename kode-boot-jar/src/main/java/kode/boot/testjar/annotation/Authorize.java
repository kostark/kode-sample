package kode.boot.testjar.annotation;

import java.lang.annotation.*;

/**
 * 授权注解
 *
 * @author Stark
 * @since 1.0
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Authorize {
}
