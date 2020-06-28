package com.qd.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	static final private String FAVICON_URL = "/static/**";
	static final private String TEMPLATES_URL = "/templates/**";

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/").addResourceLocations("/**");
        registry.addResourceHandler(FAVICON_URL).addResourceLocations("classpath:/static/");
        registry.addResourceHandler(TEMPLATES_URL).addResourceLocations("classpath:/templates/");
	}
	

}
