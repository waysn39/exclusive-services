package com.waysn.comm.aspect;

import cn.hutool.core.lang.Assert;
import com.waysn.comm.annotation.RedisLock;
import com.waysn.comm.exception.ServicesException;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Author: waysn39
 * @Date: 2021/11/18 20:19
 * @Description:
 **/
@Slf4j
@Aspect
@Component
@Order(Ordered.LOWEST_PRECEDENCE - 1)
public class RedisLockAspect {

    private static final String LOCK_NAME = "lockName";
    private static final String LOCK_WAIT = "lockWait";
    private static final String AUTO_UNLOCK_TIME = "autoUnlockTime";
    private static final String RETRY_NUM = "retryNum";
    private static final String RETRY_WAIT = "retryWait";
    private static final String LOG_GET_LOCK = "锁{%s}:加锁成功";
    private static final String LOG_UN_LOCK = "锁{%s}:解锁成功";
    private static final String LOG_LOCK_ERROR = "加锁:{%s}锁,发生异常,异常名称:{%s}";
    private static final String LOG_ERROR_NO_NAME = "锁名不能为空";
    private static final String LOG_ERROR_NO_RETRY = "锁{%s}:已被其他线程加锁且不进行重试";
    private static final String LOG_ERROR_RETRY = "锁{%s}:已被其他线程加锁，正在重试[ %s/%s ],重试间隔{%s}毫秒";

    @Resource
    private RedissonClient redissonClient;

    @SneakyThrows
    @Around("@annotation(com.waysn.comm.annotation.RedisLock) && @annotation(redisLock)")
    public Object eventPushAdvice(ProceedingJoinPoint proceedingJoinPoint, RedisLock redisLock) {
        // 获取注解中的参数
        Map<String, Object> annotationArgs = this.getAnnotationArgs(redisLock);
        String lockName = (String) annotationArgs.get(LOCK_NAME);
        Assert.notNull(lockName, LOG_ERROR_NO_NAME);
        int retryNum = (int) annotationArgs.get(RETRY_NUM);
        long retryWait = (long) annotationArgs.get(RETRY_WAIT);
        long lockWait = (long) annotationArgs.get(LOCK_WAIT);
        long autoUnlockTime = (long) annotationArgs.get(AUTO_UNLOCK_TIME);
        // 获取锁
        RLock lock = redissonClient.getLock(lockName);
        try {
            boolean res = lock.tryLock(lockWait, autoUnlockTime, TimeUnit.SECONDS);
            if (res) {
                // 执行主逻辑
                log.info(String.format(LOG_GET_LOCK, lockName));
                return proceedingJoinPoint.proceed();
            } else {
                // 如果重试次数为零, 则不重试
                if (retryNum <= 0) {
                    log.info(String.format(LOG_ERROR_NO_RETRY, lockName));
                    throw new ServicesException(-1, String.format(LOG_ERROR_NO_RETRY, lockName));
                }
                if (retryWait == 0) {
                    retryWait = 200L;
                }
                // 设置失败次数计数器, 当到达指定次数时, 返回失败
                int failCount = 1;
                while (failCount <= retryNum) {
                    // 等待指定时间ms
                    Thread.sleep(retryWait);
                    if (lock.tryLock(lockWait, autoUnlockTime, TimeUnit.SECONDS)) {
                        // 执行主逻辑
                        return proceedingJoinPoint.proceed();
                    } else {
                        log.info(String.format(LOG_ERROR_RETRY, lockName, failCount, retryNum, retryWait));
                        failCount++;
                    }
                }
                throw new ServicesException(-1, LOG_ERROR_NO_RETRY);
            }
        } catch (Throwable throwable) {
            log.error(String.format(LOG_LOCK_ERROR, lockName, throwable.getMessage()), throwable);
            throw throwable;
        } finally {
            lock.unlock();
            log.info(String.format(LOG_UN_LOCK, lockName));
        }

    }

    /**
     * 获取参数
     *
     * @return
     */
    private Map<String, Object> getAnnotationArgs(RedisLock redisLock) {
        Map<String, Object> result = new HashMap<>();
        result.put(LOCK_NAME, redisLock.prefix() + redisLock.name());
        result.put(LOCK_WAIT, redisLock.lockWait());
        result.put(AUTO_UNLOCK_TIME, redisLock.autoUnlockTime());
        result.put(RETRY_NUM, redisLock.retryLockTimes());
        result.put(RETRY_WAIT, redisLock.retryWait());
        return result;
    }
}
