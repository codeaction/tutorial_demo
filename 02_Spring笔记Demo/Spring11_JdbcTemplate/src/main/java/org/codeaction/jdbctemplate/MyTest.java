package org.codeaction.jdbctemplate;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.beans.PropertyVetoException;

public class MyTest {
    public static void main(String[] args) throws PropertyVetoException {
//        //创建数据源，Spring内部的数据源
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        //设置四大参数
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost:3306/springlearn");
//        dataSource.setUsername("root");
//        dataSource.setPassword("123456");
//
//        //创建JdbcTemplate
//        JdbcTemplate template = new JdbcTemplate();
//        //设置数据源
//        template.setDataSource(dataSource);
//
//        //执行操作
//        Integer result = template.update("insert into account(name, money) values('Tom111', 100)");
//        System.out.println(result);
        //创建c3p0数据源连接池
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        //设置四大参数
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/springlearn");
        dataSource.setUser("root");
        dataSource.setPassword("123456");

        //创建JdbcTemplate
        //JdbcTemplate template = new JdbcTemplate();
        //template.setDataSource(dataSource);
        JdbcTemplate template = new JdbcTemplate(dataSource);
        //执行操作
        template.execute("insert into account(name, money) values('Tom111', 100)");
    }
}
