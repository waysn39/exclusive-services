package com.waysn.modules.ureport.config;

import com.bstek.ureport.console.UReportServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * UReport 配置
 *
 * @author jinyiming waysn39@hotmail.com
 */
@Configuration
@ImportResource("classpath:ureport-console-context.xml")
public class UReportConfig {

    @Bean
    public ServletRegistrationBean<UReportServlet> buildUReportServlet() {
        return new ServletRegistrationBean<>(new UReportServlet(), "/ureport/*");
    }

}
