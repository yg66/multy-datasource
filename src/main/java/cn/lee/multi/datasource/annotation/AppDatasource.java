package cn.lee.multi.datasource.annotation;

import cn.lee.multi.datasource.config.DatasourceConfigRegister;
import cn.lee.multi.datasource.enums.SupportDatasourceEnum;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author lee
 * @date 2020/3/13
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(DatasourceConfigRegister.class)
public @interface AppDatasource {

    SupportDatasourceEnum[] datasourceType();
}
