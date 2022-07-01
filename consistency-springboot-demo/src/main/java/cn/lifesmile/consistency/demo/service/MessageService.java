package cn.lifesmile.consistency.demo.service;

/**
 * @author shenhuan
 * @Description MessageService
 * @Date 2022/6/29 2:33 下午
 */
public interface MessageService {


    /**
     * 发送消息
     *
     * @param message
     * @return
     */
    Boolean sendMessage(String message);
}
