package com.hand.infra.config;

import com.hand.infra.util.MyEndpoint;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.jetty.JettyEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Program: TestSpringBoot
 * @Description:
 * @Author: Youquan Deng
 * @Create: 2018-08-09 19:40
 **/
@Configuration
public class SpringBootConfig {
    @Bean
    public MyEndpoint myEndPoint() {
        return new MyEndpoint();
    }

    /*@Bean
    public EmbeddedServletContainerFactory servletContainer(){
        JettyEmbeddedServletContainerFactory factory = new JettyEmbeddedServletContainerFactory();
        factory.setPort(8888);
        return factory;
    }*/
}
