package cn.lifesmile.consistency.demo.fail;

import cn.hutool.json.JSONUtil;
import cn.lifesmile.consistency.demo.order.OrderInfoDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 自定义降级类
 **/
@Component
@Slf4j
public class SendMessageFallbackHandler {


    // 注：降级方法要与原方法的方法名，方法入参、返回值都完全一样

    public void send(OrderInfoDTO orderInfo) {

        log.info("触发send方法的降级逻辑...{}", orderInfo);
    }

    public void sendRightNowAsyncMessage(OrderInfoDTO orderInfo) {
        log.info("[立即执行异步任务测试] 降级逻辑 执行sendRightNowAsyncMessage(OrderInfoDTO)方法 {}",
                JSONUtil.toJsonStr(orderInfo));
        System.out.println(1 / 0); // 模拟降级也失败的情况
    }

}
