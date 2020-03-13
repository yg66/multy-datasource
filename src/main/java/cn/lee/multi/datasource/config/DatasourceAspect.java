package cn.lee.multi.datasource.config;

import cn.lee.multi.datasource.annotation.UsingDatasource;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

/**
 * @author lee
 * @date 2020/3/13
 */
@Slf4j
@Aspect
@Configuration
public class DatasourceAspect {
    public DatasourceAspect() {
        log.info("this is init");
    }

    @Pointcut("@within(cn.lee.multi.datasource.annotation.UsingDatasource) || @annotation(cn.lee.multi.datasource.annotation.UsingDatasource)")
    public void pointCut() {

    }

    @Before("pointCut() && @annotation(usingDatasource)")
    public void doBefore(UsingDatasource usingDatasource) {
        log.info("select datasource---" + usingDatasource.type());
        DataSourceContextHolder.setDatasourceHolder(usingDatasource.type());
    }

    @After("pointCut()")
    public void doAfter() {
        DataSourceContextHolder.clear();
    }
}
