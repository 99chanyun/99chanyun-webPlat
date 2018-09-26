/**
 * 
 */
package com.chanyun.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.chanyun.interceptor.UrlInterceptor;

/**
 * 返回静态页面 配制 类 -重写WebMvcConfigurerAdapter类中的addViewControllers 方法
 * 
 * @author liuyang
 * @Function
 * @since JDK 1.7
 * @date: 2017年3月27日 上午9:42:10
 */
@Configuration
public class MvcConfigurer extends WebMvcConfigurerAdapter {
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("forward:/index.html");
		registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
	}

	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		super.configurePathMatch(configurer);
		configurer.setUseSuffixPatternMatch(false);
	}
	
	@Override  
    public void addInterceptors(InterceptorRegistry registry) {  
        // 多个拦截器组成一个拦截器链  
        // addPathPatterns 用于添加拦截规则  
        // excludePathPatterns 用户排除拦截  
//        registry.addInterceptor(new UrlInterceptor()).addPathPatterns("/**").excludePathPatterns("/api/**");  
        super.addInterceptors(registry);  
    }  

}
