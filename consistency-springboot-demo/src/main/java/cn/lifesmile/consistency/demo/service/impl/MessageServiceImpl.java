package cn.lifesmile.consistency.demo.service.impl;

import cn.lifesmile.consistency.annotation.ConsistencyTask;
import cn.lifesmile.consistency.demo.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author shenhuan
 * @Description TODO
 * @Date 2022/6/29 2:34 下午
 */
@Service
@Slf4j
public class MessageServiceImpl implements MessageService {


    @ConsistencyTask()
    @Override
    public Boolean sendMessage(String message) {
        log.info("Message:[{}]", message);
        return true;
    }
}
