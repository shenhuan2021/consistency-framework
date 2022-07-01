package cn.lifesmile.consistency.annotation;

import cn.lifesmile.consistency.enums.ThreadWayEnum;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 一致性任务注解
 * @author shawn
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.METHOD)
public @interface ConsistencyTask {
    /**
     * 执行间隔默认60s
     *
     * @return 执行时间间隔
     */
    int executeIntervalSec() default 20;

    /**
     * 初始化延迟时间s 默认60s
     *
     * @return 执行任务的延迟时间
     */
    int delayTimeSec() default 60;

    /**
     * 线程模型  默认是异步
     *
     * @return 线程模型
     */
    ThreadWayEnum threadWay() default ThreadWayEnum.ASYNC;
}
