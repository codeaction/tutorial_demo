package org.codeaction.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//SpringMVC的配置类
@Configuration
@ComponentScan(value = "org.codeaction", includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {org.springframework.stereotype.Controller.class})
})
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    //配置视图解析器
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/pages/");
        resolver.setSuffix(".jsp");

        registry.viewResolver(resolver);
    }

    //配置静态资源不过滤
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("/css/");
        registry.addResourceHandler("/images/**").addResourceLocations("/images/");
        registry.addResourceHandler("/js/**").addResourceLocations("/js/");
    }
}
