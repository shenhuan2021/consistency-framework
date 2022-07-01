package cn.lifesmile.consistency.config;

import cn.lifesmile.consistency.config.ComponentScanConfig;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 导入配置
 * @author shawn
 */
public class ConsistencyTaskSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{ComponentScanConfig.class.getName()};
    }
}
