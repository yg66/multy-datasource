package cn.lee.multi.datasource.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * spring内部的AbstractRoutingDataSource动态路由数据源里面有一个抽象方法叫做determineCurrentLookupKey
 * 这个方法适用于提供给开发者自定义对应数据源的查询key
 *
 * @author lee
 * @date 2020/3/13
 */
public class DynamicDatasource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.getDatasourceHolder();
    }
}
