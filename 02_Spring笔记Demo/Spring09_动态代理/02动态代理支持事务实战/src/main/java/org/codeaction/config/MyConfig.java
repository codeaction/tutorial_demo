package org.codeaction.config;

import org.codeaction.proxy.ActAdvice;
import org.codeaction.proxy.AfterAdvice;
import org.codeaction.proxy.BeforeAdvice;
import org.codeaction.proxy.ProxyFactory;
import org.codeaction.service.IAccountService;
import org.codeaction.util.JdbcUtils;
import org.springframework.context.annotation.*;

import java.sql.SQLException;

@Configuration
@ComponentScan(basePackages = "org.codeaction")
@PropertySource("classpath:jdbc.properties")
@Import(JdbcConfig.class)
public class MyConfig {
    /**
     *
     * @param factory 代理工厂
     * @param accountService 目标对象
     * @return
     */
    @Bean("proxyAccountService")
    public IAccountService createProxyAccountService(ProxyFactory factory, IAccountService accountService) {
        factory.setTargetObject(accountService);
        factory.setBeforeAdvice(new BeforeAdvice() {
            @Override
            public void before() throws Exception {
                //开启事务
                JdbcUtils.beginTransaction();
            }
        });

        factory.setAfterAdvice(new AfterAdvice() {
            @Override
            public void after() throws Exception {
                //提交事务
                JdbcUtils.commitTransaction();
            }
        });

        factory.setActAdvice(new ActAdvice() {
            @Override
            public void act() throws Exception {
                //回滚
                JdbcUtils.rollbackTransaction();
            }
        });

        return (IAccountService)factory.createProxyObject();
    }
}
