package org.codeaction.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "org.codeaction")
@PropertySource("classpath:jdbc.properties")
@Import({JdbcConfig.class, TransactionConfig.class})
@EnableTransactionManagement
public class SpringConfig {
}
