package cn.lifesmile.consistency.demo.alertm;


import cn.lifesmile.consistency.custom.alerter.ConsistencyFrameworkAlerter;
import cn.lifesmile.consistency.model.ConsistencyTaskInstance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 自定义告警通知类  需要实现ConsistencyFrameworkAlerter类
 *
 **/
@Component
@Slf4j
public class NormalAlerter implements ConsistencyFrameworkAlerter {


    /**
     * 发送告警通知 拿到告警实例通知给对应的人 要通知的人 在该方法中实现即可
     *
     * @param consistencyTaskInstance 发送告警通知
     */
    @Override
    public void sendAlertNotice(ConsistencyTaskInstance consistencyTaskInstance) {
        log.info("执行告警通知逻辑... 方法签名为：{}", consistencyTaskInstance.getMethodSignName());
    }

}
