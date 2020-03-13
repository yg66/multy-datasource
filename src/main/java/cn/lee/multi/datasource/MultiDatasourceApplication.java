package cn.lee.multi.datasource;

import cn.lee.multi.datasource.annotation.AppDatasource;
import cn.lee.multi.datasource.enums.SupportDatasourceEnum;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AppDatasource(datasourceType = {SupportDatasourceEnum.PROD_DB, SupportDatasourceEnum.DEV_DB, SupportDatasourceEnum.PRE_DB})
public class MultiDatasourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultiDatasourceApplication.class, args);
    }

}
