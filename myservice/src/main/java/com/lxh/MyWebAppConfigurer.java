package com.lxh;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {
	@Bean
	public LocaleResolver localeResolver() {
		// for this demo, we'll use a SessionLocaleResolver object
		// as the name implies, it stores locale info in the session
		SessionLocaleResolver resolver = new SessionLocaleResolver();

		// default to US locale
		resolver.setDefaultLocale(Locale.US);

		// get out
		return resolver;
	}

	/**
	 * This interceptor allows visitors to change the locale on a per-request basis
	 * 
	 * @return a LocaleChangeInterceptor object
	 */
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		// instantiate the object with an empty constructor
		LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();

		// the request param that we'll use to determine the locale
		interceptor.setParamName("lang");

		// get out
		return interceptor;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 多个拦截器组成一个拦截器链
		// addPathPatterns 用于添加拦截规则
		// excludePathPatterns 用户排除拦截
		// registry.addInterceptor(new
		// ErrorInterceptorController()).addPathPatterns("/**").excludePathPatterns("/static");
		registry.addInterceptor(localeChangeInterceptor());
		super.addInterceptors(registry);
		
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
		super.addResourceHandlers(registry);
		// addResourceHandler指的是对外暴露的访问路径,addResourceLocations指的是文件放置的目录，
	}
}