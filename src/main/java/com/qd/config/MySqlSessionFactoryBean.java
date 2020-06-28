package com.qd.config;

import com.qd.XyeQdBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * MyBatis基础配置
 */
@Configuration
@EnableTransactionManagement
public class MySqlSessionFactoryBean{
	
    DataSource dataSource;
    @Value("${spring.datasource.url}")
    private String url;
	@Value("${spring.datasource.driver-class-name}")
    private String driverName;
	@Value("${spring.datasource.username}")
    private String userName;
	@Value("${spring.datasource.password}")
    private String password;
    
    private final Logger logger = LoggerFactory.getLogger(MySqlSessionFactoryBean.class); 
    

	@Bean(destroyMethod="")
	public DataSource dataSource() throws IllegalArgumentException, NamingException {
		logger.info(">>>>>>>>>>load dataSource start,url:{}<<<<<<<<<<",url);
		DataSourceBuilder factory = DataSourceBuilder
			.create(XyeQdBootApplication.class.getClassLoader()).driverClassName(driverName)
			.url(url).username(userName).password(password);
		dataSource= factory.build();
		logger.info(">>>>>>>>>>load dataSource end,url<<<<<<<<<<");
		return  dataSource;
	}
	
	
	 

}
