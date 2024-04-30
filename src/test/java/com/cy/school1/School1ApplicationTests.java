package com.cy.school1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class School1ApplicationTests {

    @Autowired(required = false) //自动装配
    private DataSource dataSource;

    @Test
    void contextLoads() {
    }

    /*
     * 数据库连接池：
     * 1.DBCP
     * 2.C3P0
     * 3.Hikari:管理数据库的连接对象
     * 最快的连接池
     * HikariProxyConnection@1005928818 wrapping com.mysql.cj.jdbc.ConnectionImpl@2c9a6717
     * */
    @Test
    void getConnection() throws SQLException {
        System.out.println(dataSource.getConnection());
    }

}
