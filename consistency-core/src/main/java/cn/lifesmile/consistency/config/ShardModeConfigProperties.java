package cn.lifesmile.consistency.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 任务分库相关的配置
 *
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "consistency.task.shard")
public class ShardModeConfigProperties {

    /**
     * 任务表是否进行分库
     */
    public Boolean taskSharded = false;
    /**
     * 生成任务表分片key的ClassName 这里要配置类型全路径且类要实现ShardingKeyGenerator接口
     */
    private String shardingKeyGeneratorClassName = "";

}
