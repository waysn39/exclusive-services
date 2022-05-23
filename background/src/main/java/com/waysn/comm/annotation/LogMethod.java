package com.waysn.comm.annotation;

import java.lang.annotation.*;

/**
 * 这个注解可以用来测试方法效率
 * value为Tag方便查找日志
 * 记录内容包含：所进入的方法名，参数，异常，返回值，以及耗时
 * 无法作用私有方法
 * 因动态代理导致失效，请使用LogMethodAspect.getCurrentBean在调用对应方法
 *
 * @author jinyiming
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LogMethod {
    String value() default "";
}
