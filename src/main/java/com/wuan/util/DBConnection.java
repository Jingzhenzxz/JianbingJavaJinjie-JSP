package com.wuan.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;
public class DBConnection {
    // 使用c3p0连接池
    // ComboPooledDataSource是c3p0的一个数据源
    // 通过它可以获取数据库连接
    private static final ComboPooledDataSource cpds;

    // 静态代码块，只会执行一次
    static {
        // 使用默认构造函数将自动从c3p0-config.xml文件加载配置
        // 如果没有指定配置文件，将使用默认配置
        // 默认配置：c3p0-config.xml
        cpds = new ComboPooledDataSource();
    }

    // 通过连接池获取连接，不需要手动关闭连接
    // 连接池会自动管理连接
    public static Connection getConnection() throws SQLException {
        return cpds.getConnection();
    }
}
