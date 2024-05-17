package com.busanit501.serverprogramtest2.todo.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;

public enum ConnectionUtil {
    INSTANCE;

    // 주입 , 포함
   private HikariDataSource dataSource;

   ConnectionUtil() {

       HikariConfig config = new HikariConfig();
       config.setDriverClassName("org.mariadb.jdbc.Driver");
       config.setJdbcUrl("jdbc:mariadb://localhost:3306/webdb");
       config.setUsername("webuser");
       config.setPassword("webuser");

       config.addDataSourceProperty("cachePrepStmts", "true");
       config.addDataSourceProperty("prepStmtCacheSize", "250");
       config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");


       dataSource = new HikariDataSource(config);
   }
   // Connection 리턴 해주는 , 매서드, 디비 연결하는 도구
       public Connection getConnection() throws Exception {
           return dataSource.getConnection();
       }
}
