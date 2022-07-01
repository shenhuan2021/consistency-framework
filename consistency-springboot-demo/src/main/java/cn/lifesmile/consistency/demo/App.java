package cn.lifesmile.consistency.demo;

import cn.lifesmile.consistency.annotation.EnableConsistencyTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author shenhuan
 * @Description App
 * @Date 2022/6/29 2:21 下午
 */

@SpringBootApplication
@Slf4j
@EnableConsistencyTask
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        log.info("App Start....");
    }
}
