package cn.lifesmile.consistency.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 导入配置
 */
public class ConsistencyTaskSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClasscetadata) {
        return new String[]{ComponentScanConfig.class.getName()};
    }
}
