package com.qk.commonservice.annotation;

import java.lang.annotation.*;

/**
 * @author zhangyu
 * @data 2018/7/13
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLogger {
    String value() default "";
}
