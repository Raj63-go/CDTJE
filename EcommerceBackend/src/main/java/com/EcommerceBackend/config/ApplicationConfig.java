package com.EcommerceBackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@ComponentScan("com.niit.EcommerceBackend")
@EnableTransactionManagement
public class ApplicationConfig {
	
	
	
	public static final String DRIVER_NAME="oracle.jdbc.driver.OracleDriver";
	public static final String DATABASE_URL="jdbc:oracle:thin:@localhost:1521:xe";
	public static final String USERNAME="SHOPCART";
	public static final String PASSWORD="password";



@Bean("dataSource")
public DataSource getDataSource() {
	BasicDataSource dataSource = new BasicDataSource();
	
	dataSource.setDriverClassName(DRIVER_NAME);
	dataSource.setUrl(DATABASE_URL);
	dataSource.setUsername(USERNAME);
	dataSource.setPassword(PASSWORD);
	
	return dataSource;
	
}

@Bean
public SessionFactory getSessionFactory(DataSource dataSource) {
	LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
	builder.addProperties(getHibernateProperties());
	builder.scanPackages("");
	
	return builder.buildSessionFactory();
}

private Properties getHibernateProperties() {
	Properties properties = new Properties();
	properties.put("hibernate.show_sql", "true");
	properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
	properties.put("hibernate.format_sql", true);
	
	return properties;
}

@Bean
public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
	HibernateTransactionManager transactionManager= new HibernateTransactionManager(sessionFactory);
	
	return transactionManager;
	
}



}