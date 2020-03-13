package cn.lee.multi.datasource.annotation;

import cn.lee.multi.datasource.enums.SupportDatasourceEnum;

import java.lang.annotation.*;

/**
 * @author lee
 * @date 2020/3/13
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UsingDatasource {
    SupportDatasourceEnum type();
}
