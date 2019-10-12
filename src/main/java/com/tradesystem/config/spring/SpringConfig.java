package com.tradesystem.config.spring;

import com.tradesystem.service.TestBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    @Bean
    public TestBean getTestBean() {
        return new TestBean("Hello");
    }

    @Bean
    public JdbcTemplate getJdbcTemplate() {
       return new JdbcTemplate(getDataSource());
    }
    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
       dataSource.setUrl("jdbc:mysql://localhost:3306/trade_system");
        dataSource.setUsername("root");
        dataSource.setPassword("SlowdiveAlison72");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        return dataSource;
    }
}
