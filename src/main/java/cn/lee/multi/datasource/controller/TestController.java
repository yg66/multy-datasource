package cn.lee.multi.datasource.controller;

import cn.lee.multi.datasource.annotation.UsingDatasource;
import cn.lee.multi.datasource.enums.SupportDatasourceEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lee
 * @date 2020/3/13
 */
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/testDev")
    @UsingDatasource(type = SupportDatasourceEnum.DEV_DB)
    public void testDev() {
        showData();
    }

    @GetMapping("/testProd")
    @UsingDatasource(type = SupportDatasourceEnum.PROD_DB)
    public void testProd() {
        showData();
    }

    private void showData() {
        jdbcTemplate.queryForList("select * from user").forEach(row -> log.info(row.toString()));
    }
}
