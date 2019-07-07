package com.cat.sleepy.sleepycat.config.database;

import javax.sql.DataSource;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@MapperScan(basePackages="com.cat.sleepy.sleepycat", annotationClass=Mapper.class, sqlSessionFactoryRef="mariaSessionFactory")
@EnableTransactionManagement
public class DataBaseConfig {
	
	@Value("${dbconfig.db1MapperLocation}")
	private String dbMapperLocation;
	
	@Bean(name="mariaDataSource")
	@ConfigurationProperties(prefix="spring.datasource")
	public DataSource mariaDataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name="mariaSessionFactory")
	public SqlSessionFactory mariaSessionFactory(@Qualifier("mariaDataSource") DataSource mariaDataSource, ApplicationContext applicationContext) throws Exception {
		SqlSessionFactoryBean mariaSessionFactoryBean = new SqlSessionFactoryBean();
		mariaSessionFactoryBean.setDataSource(mariaDataSource);
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		mariaSessionFactoryBean.setConfigLocation(applicationContext.getResource("classpath:mybatis-config.xml"));
		mariaSessionFactoryBean.setMapperLocations(resolver.getResources(dbMapperLocation));
		return mariaSessionFactoryBean.getObject();
	}
	
	@Bean(name="mariaSessionTemplate")
	public SqlSessionTemplate mariaSessionTemplate(SqlSessionFactory mariaSessionTemplate) throws Exception{
		return new SqlSessionTemplate(mariaSessionTemplate);
	}
}
