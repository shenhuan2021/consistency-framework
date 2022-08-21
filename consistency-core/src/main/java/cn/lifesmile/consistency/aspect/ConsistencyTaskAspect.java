package cn.lifesmile.consistency.aspect;

import cn.hutool.json.JSONUtil;
import cn.lifesmile.consistency.annotation.ConsistencyTask;
import cn.lifesmile.consistency.enums.ConsistencyTaskStatusEnum;
import cn.lifesmile.consistency.enums.PerformanceEnum;
import cn.lifesmile.consistency.model.ConsistencyTaskInstance;
import cn.lifesmile.consistency.service.TaskStoreService;
import cn.lifesmile.consistency.utils.ReflectTools;
import cn.lifesmile.consistency.utils.TimeUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * 切面
 */
@Slf4j
@Aspect
@Component
public class ConsistencyTaskAspect {

    /**
     * 一致性任务的service
     */
    @Autowired
    private TaskStoreService taskStoreService;

    @Around("@annotation(consistencyTask)")
    public Object consistencyTask(ProceedingJoinPoint point, ConsistencyTask consistencyTask) {
        log.info("consistencyTask-> method:{} is called on {} args {}", point.getSignature().getName(), point.getThis(), point.getArgs());

        ConsistencyTaskInstance taskInstance = createTaskInstance(consistencyTask, point);

        taskStoreService.initTask(taskInstance);

        return null;
    }


    /**
     * 根据注解构造构造最终一致性任务的实例
     *
     * @param task  一致性任务注解信息 相当于任务的模板
     * @param point 方法切入点
     * @return 一致性任务实例
     */
    private ConsistencyTaskInstance createTaskInstance(ConsistencyTask task, JoinPoint point) {
        // 通过@ConsistencyTask注解提取一系列的参数
        // 通过JoinPoint切入点，可以提取一系列的方法相关的数据

        // 根据入参数组获取对应的Class对象的数组
        Class<?>[] argsClazz = ReflectTools.getArgsClass(point.getArgs());
        // 获取被拦截方法的全限定名称 格式：类路径#方法名(参数1的类型,参数2的类型,...参数N的类型)
        String fullyQualifiedName = ReflectTools.getTargetMethodFullyQualifiedName(point, argsClazz);
        // 获取入参的类名称数组
        String parameterTypes = ReflectTools.getArgsClassNames(point.getSignature());

        Date date = new Date();

        // 一次任务执行 = 一次方法调用
        ConsistencyTaskInstance instance = ConsistencyTaskInstance.builder()
                // taskId，他默认用的就是方法全限定名称，所以说，针对一个方法n多次调用，taskId是一样的
                // taskId并不是唯一的id标识
                .taskId(StringUtils.isEmpty(task.id()) ? fullyQualifiedName : task.id()).methodName(point.getSignature().getName()) // 调用方法名称
                .parameterTypes(parameterTypes) // 调用方法入参的类型名称
                .methodSignName(fullyQualifiedName) // 方法签名
                .taskParameter(JSONUtil.toJsonStr(point.getArgs())) // 调用方法入参的对象数组，json串的转化
                .performanceWay(task.performanceWay().getCode()) // 注解里配置的执行模式，直接执行 vs 调度执行
                .threadWay(task.threadWay().getCode()) // 注解里配置的直接执行，同步还是异步，sync还是async，async会用我们自己初始化的线程池
                .executeIntervalSec(task.executeIntervalSec()) // 每次任务执行间隔时间
                .delayTime(task.delayTime())  // 任务执行延迟时间
                .executeTimes(0) // 任务执行次数
                .taskStatus(ConsistencyTaskStatusEnum.INIT.getCode()) // 任务当前所处的一个状态
                .errorMsg("") // 任务执行的时候异常信息
                .alertExpression(StringUtils.isEmpty(task.alertExpression()) ? "" : task.alertExpression()) // 限定了你的报警要在任务执行失败多少次的范围内去报警
                .alertActionBeanName(StringUtils.isEmpty(task.alertActionBeanName()) ? "" : task.alertActionBeanName()) // 如果要告警的话，他的告警逻辑的调用bean是谁
                .fallbackClassName(ReflectTools.getFullyQualifiedClassName(task.fallbackClass())) // 如果执行失败了，你的降级类是谁
                .fallbackErrorMsg("") // 如果降级也失败了，降级失败的异常信息
                .gmtCreate(date).gmtModified(date).build();

        // 设置预期执行的时间
        instance.setExecuteTime(getExecuteTime(instance));
        // 设置分片key  暂时不只支持分片
        instance.setShardKey(0L);

        return instance;
    }


    /**
     * 获取任务执行时间
     *
     * @param taskInstance 一致性任务实例
     * @return 下次执行时间
     */
    private long getExecuteTime(ConsistencyTaskInstance taskInstance) {
        if (PerformanceEnum.PERFORMANCE_SCHEDULE.getCode().equals(taskInstance.getPerformanceWay())) {
            long delayTimeMillSecond = TimeUtils.secToMill(taskInstance.getDelayTime());
            return System.currentTimeMillis() + delayTimeMillSecond; // 如果你是调度模式，一般是跟delay time配合使用的，你要延迟多少时间去执行
        } else {
            // 如果你要是设置了right now模式来执行的话，delayTime你设置了也是无效的
            return System.currentTimeMillis(); // 执行时间就是当前时间
        }
    }
}
