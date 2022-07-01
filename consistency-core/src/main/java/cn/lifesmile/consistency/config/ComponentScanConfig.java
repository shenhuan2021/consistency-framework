package cn.lifesmile.consistency.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 组件扫描工具
 * @author shawn
 */
@Configuration
@ComponentScan(value = {"cn.lifesmile.consistency"}) // 作用是让spring去扫描框架各个包下的bean
public class ComponentScanConfig {
}
