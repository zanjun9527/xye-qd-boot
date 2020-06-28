package com.qd.config;

import org.apache.catalina.Context;
import org.apache.tomcat.util.http.LegacyCookieProcessor;
import org.springframework.boot.web.embedded.tomcat.TomcatContextCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class TomcatConfig {

	//tomcat版本升级，An invalid domain [] was specified for this cookie
	@Bean
	public WebServerFactoryCustomizer<TomcatServletWebServerFactory> cookieProcessorCustomizer() {
		// lambda写法,暂时不用
//		return (factory) -> factory.addContextCustomizers((context) -> context.setCookieProcessor(new LegacyCookieProcessor()));

		return new WebServerFactoryCustomizer<TomcatServletWebServerFactory>() {
			@Override
			public void customize(TomcatServletWebServerFactory factory) {
				factory.addContextCustomizers(new TomcatContextCustomizer() {
					@Override
					public void customize(Context context) {
						context.setCookieProcessor(new LegacyCookieProcessor());
					}
				});
			}
		};
	}

}
