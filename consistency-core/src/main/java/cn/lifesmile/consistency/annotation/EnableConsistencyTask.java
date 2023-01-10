package cn.lifesmile.consistency.annotation;

import cn.lifesmile.consistency.config.ConsistencyTaskSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 启用一致性框架
 * 需要在启动类上进行开启
 *
 * @author shawn
 */

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.TYPE)
@Import({ConsistencyTaskSelector.class})
public @interface EnableConsistencyTask {
}
