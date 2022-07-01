package cn.lifesmile.consistency;

import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * @author shenhuan
 * @Description ConsistencyTaskEntity
 * @Date 2022/6/30 4:18 下午
 */

@Repository
@Data
public class ConsistencyTaskEntity {

    private static final long serialVersionUID = 1L;


    /**
     * 主键自增
     */
    private Long id;

    /**
     * 用户自定义的任务名称，如果没有则使用方法签名
     */
    private String taskId;

    /**
     * 执行状态
     */
    private Integer taskStatus;

    /**
     * 执行次数
     */
    private Integer executeTimes;

    /**
     * 执行时间
     */
    private Long executeTime;

    /**
     * 参数的类路径名称
     */
    private String parameterTypes;

    /**
     * 方法名
     */
    private String methodName;

    /**
     * 方法签名
     */
    private String methodSignName;

    /**
     * 执行间隔秒
     */
    private Integer executeIntervalSec;

    /**
     * 延迟时间：单位秒
     */
    private Integer delayTime;

    /**
     * 任务参数
     */
    private String taskParameter;

    /**
     * 执行模式：1、立即执行 2、调度执行
     */
    private Integer performanceWay;

    /**
     * 线程模型 1、异步 2、同步
     */
    private Integer threadWay;

    /**
     * 执行的error信息
     */
    private String errorMsg;

    /**
     * 告警表达式
     */
    private String alertExpression;

    /**
     * 告警逻辑的的执行beanname
     */
    private String alertActionBeanName;

    /**
     * 降级逻辑的的类路径
     */
    private String fallbackClassName;

    /**
     * 降级失败时的错误信息
     */
    private String fallbackErrorMsg;

    /**
     * 任务分片键
     */
    private Long shardKey;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 修改时间
     */
    private Date updatedTime;

    /**
     * 创建人
     */
    private String createdBy;
}
