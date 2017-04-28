package net.nilsghesquiere.web;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.support.ErrorPageFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan
@EnableSpringDataWebSupport
public class CreateControllerBeans extends WebMvcConfigurerAdapter{

	@Bean
	InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/templates/");
		resolver.setSuffix(".html");
		return resolver;
	}
	
	//start test
	@Bean
	public ErrorPageFilter errorPageFilter() {
	    return new ErrorPageFilter();
	}

	@Bean
	public FilterRegistrationBean disableSpringBootErrorFilter(ErrorPageFilter filter) {
	    FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
	    filterRegistrationBean.setFilter(filter);
	    filterRegistrationBean.setEnabled(false);
	    return filterRegistrationBean;
	}
	
	//end test

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
		registry.addResourceHandler("/images/**").addResourceLocations("/images/");
		registry.addResourceHandler("/styles/**").addResourceLocations("/styles/");
	}
}

