package cn.lee.multi.datasource.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author lee
 * @date 2020/3/13
 */
@AllArgsConstructor
@Getter
public enum SupportDatasourceEnum {
    // 生产
    PROD_DB("jdbc:mysql://localhost:3306/db-prod?useUnicode=true&characterEncoding=utf8", "root", "root", "db-prod"),
    // 测试
    DEV_DB("jdbc:mysql://localhost:3306/db-dev?useUnicode=true&characterEncoding=utf8", "root", "root", "db-dev"),
    // 前置
    PRE_DB("jdbc:mysql://localhost:3306/db-pre?useUnicode=true&characterEncoding=utf8", "root", "root", "db-pre"),
    ;

    String url;
    String username;
    String password;
    String databaseName;

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
