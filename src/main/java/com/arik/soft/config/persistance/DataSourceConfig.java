package com.arik.soft.config.persistance;

import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.JpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Properties;

public interface DataSourceConfig {

    @Bean
    DataSource dataSource();

    @Bean
    JpaVendorAdapter jpaVendorAdaptor();

    @Bean
    Properties jpaProperties();
}
