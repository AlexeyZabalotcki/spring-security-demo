package com.alexey.security.demo.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.alexey.security.demo")
@PropertySource("classpath:prisistence-mysql.properties")
public class DemoAppConfig {

    @Autowired
    private Environment env;

    private Logger logger = Logger.getLogger(getClass().getName());

    @Bean
    public ViewResolver viewResolver() {

        InternalResourceViewResolver viewResolwer = new InternalResourceViewResolver();

        viewResolwer.setPrefix("/WEB-INF/view/");
        viewResolwer.setSuffix(".jsp");

        return viewResolwer;
    }

    @Bean
    public DataSource securityDataSource() {

        ComboPooledDataSource securityDataSource = new ComboPooledDataSource();

        try {
            securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
        } catch (PropertyVetoException exc) {
            throw new RuntimeException(exc);
        }

        logger.info(">>> jdbc.url=" + env.getProperty("jdbc.url"));
        logger.info(">>> jdbc.user=" + env.getProperty("jdbc.user"));

        securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
        securityDataSource.setUser(env.getProperty("jdbc.user"));
        securityDataSource.setPassword(env.getProperty("jdbc.password"));

        securityDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
        securityDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
        securityDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
        securityDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));

        return securityDataSource;
    }

    private int getIntProperty(String propName) {

        String propValue = env.getProperty(propName);

        int intPropVal = Integer.parseInt(propValue);

        return intPropVal;
    }
}
