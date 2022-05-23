package com.waysn.comm.annotation;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.lang.annotation.*;

/**
 * @Author: waysn39
 * @Date: 2021/11/18 20:20
 * @Description:
 **/
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Order(value = Ordered.LOWEST_PRECEDENCE - 1)
public @interface RedisLock {

    /**
     * 前缀
     *
     * @return
     */
    String prefix() default "";

    /**
     * 锁名称
     *
     * @return
     */
    String name() default "";

    /**
     * 加锁等待时间
     *
     * @return
     */
    long lockWait() default 50L;


    /**
     * 解锁时间
     *
     * @return
     */
    long autoUnlockTime() default 2000L;

    /**
     * 重试加锁次数
     *
     * @return
     */
    int retryLockTimes() default 3;

    /**
     * 重试加锁间隔时间
     *
     * @return
     */
    long retryWait() default 50L;
}
