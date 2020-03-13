package cn.lee.multi.datasource.config;

import cn.lee.multi.datasource.enums.SupportDatasourceEnum;

import java.util.HashSet;

/**
 * 对每个请求线程的数据源信息做统一的分配和管理
 * <p>
 * 在多并发场景下，为了防止不同线程请求的数据源出现“互窜”情况，通常我们都会使用到threadLocal来做处理
 * 为每一个线程都分配一个指定的，属于其内部的副本变量，当当前线程结束之前，记得将对应的线程副本也进行销毁
 *
 * @author lee
 * @date 2020/3/13
 */
public class DataSourceContextHolder {
    private static final HashSet<SupportDatasourceEnum> DATASOURCE_SET = new HashSet<>();
    private static final ThreadLocal<String> DATASOURCE_HOLDER = new ThreadLocal<>();

    public static void setDatasourceHolder(SupportDatasourceEnum supportDatasourceEnum) {
        DATASOURCE_HOLDER.set(supportDatasourceEnum.toString());
    }

    /**
     * 取得当前数据源
     */
    public static String getDatasourceHolder() {
        return DATASOURCE_HOLDER.get();
    }

    /**
     * 添加数据源
     */
    public static void addDatasource(SupportDatasourceEnum supportDatasourceEnum) {
        DATASOURCE_SET.add(supportDatasourceEnum);
    }

    /**
     * 获取当前应用所支持的所有数据源
     */
    public static HashSet<SupportDatasourceEnum> getDatasourceSet() {
        return DATASOURCE_SET;
    }

    /**
     * 清除上下文数据
     */
    public static void clear() {
        DATASOURCE_HOLDER.remove();
    }
}
