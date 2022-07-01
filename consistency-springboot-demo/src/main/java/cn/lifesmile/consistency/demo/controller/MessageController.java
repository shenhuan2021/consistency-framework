package cn.lifesmile.consistency.demo.controller;

import cn.lifesmile.consistency.demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shenhuan
 * @Description TODO
 * @Date 2022/6/29 2:27 下午
 */
@RestController
@RequestMapping("/api/message")
public class MessageController {


    @Autowired
    private MessageService messageService;

    @GetMapping("")
    public String sendMessage(@RequestParam("message") String message) {
        Boolean sendStatus = messageService.sendMessage(message);
        return "status: " + sendStatus;
    }
}
