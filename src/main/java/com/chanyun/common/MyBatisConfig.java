package com.chanyun.common;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * 
 * @Description:SpringBoot集成MyBatis入口
 * 1) 创建数据) 创建SqlSessionFactory
 * @author liuyang
 * @data  2017-6-17 上午10:11:40
 *
 */

//@Configuration
public class MyBatisConfig {

	@Autowired
	private Environment environment ;
	
	/**
	 * 
	 * 创建数据*/
	@Bean
	public DataSource getDataSource() throws Exception {
		
		Properties properties = new Properties() ;
		String driverClassName = environment.getProperty("test.properties.driverClass");
		properties.put("driverClassName", driverClassName) ;
		properties.put("url", environment.getProperty("test.properties.url")) ;
		properties.put("username", environment.getProperty("test.properties.username")) ;
		properties.put("password", environment.getProperty("test.properties.password")) ;
		return DruidDataSourceFactory.createDataSource(properties) ;
	}
	
	/**
	 * 根据数据源创建SqlSessionFactory
	 */
	@Bean
	public SqlSessionFactory getSqlSessionFactory(DataSource dataSource) throws Exception {
		
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean() ;
		sqlSessionFactoryBean.setDataSource(dataSource) ;
		//下边两句仅仅用于*.xml文件，如果整个持久层操作不需要使用到xml文件的话（只用注解就可以搞定），则不�?		
		sqlSessionFactoryBean.setTypeAliasesPackage(environment.getProperty("mybatis.typeAliasesPackage"));//指定基包
		sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(environment.getProperty("mybatis.mapperLocations")));//指定xml文件位置
		//把数据库的下划线列映射到javabean的驼峰属性上  顾理�?add by 2017-5-9
		sqlSessionFactoryBean.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
		return sqlSessionFactoryBean.getObject() ;
	}
}
