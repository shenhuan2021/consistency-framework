package cn.lifesmile.consistency.aspect;

import cn.lifesmile.consistency.annotation.ConsistencyTask;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 切面
 * @author shawn
 */
@Slf4j
@Aspect
@Component
public class ConsistencyTaskAspect {


    @Around("@annotation(consistencyTask)")
    public Object consistencyTask(ProceedingJoinPoint point, ConsistencyTask consistencyTask) {
        log.info("consistencyTask-> method:{} is called on {} args {}", point.getSignature().getName(), point.getThis(), point.getArgs());
        return null;
    }
}
