package org.codeaction.config;


import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

//Spring的配置类
@Configuration
@ComponentScan(value = "org.codeaction", excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {org.springframework.stereotype.Controller.class})
})
@PropertySource("classpath:jdbc.properties")
@Import({JdbcConfig.class, TransactionConfig.class})
@EnableTransactionManagement
@MapperScan(basePackages = "org.codeaction.dao")
public class RootConfig {

    //配置MyBatis的Bean工厂
    @Bean("sqlSessionFactory")
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);

        return sqlSessionFactoryBean;
    }
}
