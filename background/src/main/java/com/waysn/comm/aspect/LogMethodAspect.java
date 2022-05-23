package com.waysn.comm.aspect;

import com.waysn.comm.annotation.LogMethod;
import com.waysn.comm.utils.SpringContextUtils;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;


/**
 * @author jinyiming
 */
@Aspect
@Slf4j
@Component
@Order(Ordered.LOWEST_PRECEDENCE - 1)
public class LogMethodAspect {
    @Pointcut("@annotation(com.waysn.comm.annotation.LogMethod)")
    private void pointcut() {
        //切面声明
    }

    @SneakyThrows
    @Around("pointcut() && @annotation(logger)")
    public Object advice(ProceedingJoinPoint proceedingJoinPoint, LogMethod logger) {
        /*result为连接点的放回结果*/
        Object result = null;
        String methodName = proceedingJoinPoint.getSignature().getName();
        Long startTime = System.currentTimeMillis();
        String errorInfo = "";
        Throwable error = null;
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            errorInfo = e.getMessage();
            error = e;
        }
        Long endTime = System.currentTimeMillis();
        log.info("\nLogTag:{}\nMethodName：{}\nParams：{}\nThrowable：{}\nReturn：{}\nCostTime：{} ms;",
                logger.value(), methodName, Arrays.asList(proceedingJoinPoint.getArgs()), errorInfo, result, getTimeStamp(endTime - startTime));
        if (error != null) {
            throw error;
        }

        return result;
    }

    public static <T> T getCurrentBean(Class<T> requiredType) {
        return SpringContextUtils.getBean(requiredType);
    }

    public String getTimeStamp(Long time) {
        return String.valueOf(time);
    }
}
