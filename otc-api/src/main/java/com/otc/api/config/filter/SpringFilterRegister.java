package com.otc.api.config.filter;

import com.otc.platform.springmvc.WebContextFilter;
import net.bull.javamelody.MonitoringFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
public class SpringFilterRegister {

  @Bean
  public FilterRegistrationBean WebContextFilterRegistration() {
    FilterRegistrationBean registration = new FilterRegistrationBean();
    registration.setFilter(new WebContextFilter());
    registration.addUrlPatterns("/*");
    registration.setName("webContextFilter");
    registration.setOrder(1);
    return registration;
  }

  @Bean
  public FilterRegistrationBean NoCacheFilterRegistration() {
    FilterRegistrationBean registration = new FilterRegistrationBean();
    registration.setFilter(new NoCacheFilter());

    registration.addUrlPatterns("/openapi/*");
    registration.addUrlPatterns("/wap/*");
    registration.addUrlPatterns("/app/*");
    registration.addUrlPatterns("/web/*");

    registration.setName("noCacheFilter");
    registration.setOrder(10);
    return registration;
  }

}
