package cn.lee.multi.datasource.config;

import cn.lee.multi.datasource.annotation.AppDatasource;
import cn.lee.multi.datasource.enums.SupportDatasourceEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;

/**
 * @author lee
 * @date 2020/3/13
 */
@Slf4j
@Component
public class DatasourceConfigRegister implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        AnnotationAttributes attributes = AnnotationAttributes.fromMap(annotationMetadata.getAnnotationAttributes(AppDatasource.class.getName()));
        log.info("##### datasource import #####");
        if (null != attributes) {
            Object object = attributes.get("datasourceType");
            SupportDatasourceEnum[] supportDatasourceEnums = (SupportDatasourceEnum[]) object;
            for (SupportDatasourceEnum supportDatasourceEnum : supportDatasourceEnums) {
                DataSourceContextHolder.addDatasource(supportDatasourceEnum);
            }
        }
        return new String[0];
    }
}
