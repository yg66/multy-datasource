package cn.lee.multi.datasource.config;

import cn.lee.multi.datasource.enums.SupportDatasourceEnum;
import com.alibaba.druid.pool.DruidDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author lee
 * @date 2020/3/13
 */
@Slf4j
@Component
public class DynamicDatasourceConfiguration {

    @Bean
    @Primary
    @ConditionalOnMissingBean
    public DataSource dataSource() {
        log.info("init datasource");
        DynamicDatasource dynamicDatasource = new DynamicDatasource();
        // 设置原始数据源
        HashMap<Object, Object> datasourceMap = new HashMap<>();
        HashSet<SupportDatasourceEnum> datasourceSet = DataSourceContextHolder.getDatasourceSet();
        for (SupportDatasourceEnum supportDatasourceEnum : datasourceSet) {
            DataSource datasourceProperties = this.createDatasourceProperties(supportDatasourceEnum);
            datasourceMap.put(supportDatasourceEnum.toString(), datasourceProperties);
        }
        dynamicDatasource.setTargetDataSources(datasourceMap);
        dynamicDatasource.setDefaultTargetDataSource(createDatasourceProperties(SupportDatasourceEnum.PRE_DB));
        return dynamicDatasource;
    }

    private synchronized DataSource createDatasourceProperties(SupportDatasourceEnum supportDatasourceEnum) {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(supportDatasourceEnum.getUrl());
        druidDataSource.setUsername(supportDatasourceEnum.getUsername());
        druidDataSource.setPassword(supportDatasourceEnum.getPassword());
        // 具体配置
        druidDataSource.setMaxActive(100);
        druidDataSource.setInitialSize(5);
        druidDataSource.setMinIdle(1);
        druidDataSource.setMaxWait(30000);
        // 间隔多久进行一次检测，检测需要关闭的空闲连接，单位是毫秒
        druidDataSource.setTimeBetweenConnectErrorMillis(60000);
        return druidDataSource;
    }
}
