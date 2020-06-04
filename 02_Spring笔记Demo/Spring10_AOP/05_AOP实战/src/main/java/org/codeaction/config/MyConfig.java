package org.codeaction.config;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = "org.codeaction")
@PropertySource("classpath:jdbc.properties")
@Import(JdbcConfig.class)
@EnableAspectJAutoProxy
public class MyConfig {
}
