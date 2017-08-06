package com.arik.soft.config.persistance;

import com.arik.soft.infra.Profiles;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@Profile(Profiles.PROD)
@PropertySource("db-prod.properties")
public class PostgresDatabaseConfig implements DataSourceConfig {

    @Value("${db.schema.name}")
    private String schemaName;

    @Value("${hibernate.hbm2ddl.auto}")
    private String schemaOperation;

    @Value("${db.username}")
    private String dbUserName;

    @Value("${db.password}")
    private String dbPassword;

    @Value("${db.url}")
    private String dbUrl;

    @Value("${db.driverClassName}")
    private String driverClassName;

    @Override
    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder
                .create()
                .username(dbUserName)
                .password(dbPassword)
                .url(dbUrl)
                .driverClassName(driverClassName)
                .build();
    }

    @Override
    @Bean
    public JpaVendorAdapter jpaVendorAdaptor() {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setDatabase(Database.POSTGRESQL);
        return hibernateJpaVendorAdapter;
    }

    @Override
    @Bean
    public Properties jpaProperties() {
        Properties jpaProperties = new Properties();
        jpaProperties.setProperty("hibernate.hbm2ddl.auto", schemaOperation);
        jpaProperties.setProperty("hibernate.default_schema", schemaName);
        return jpaProperties;
    }
}
