package com.arik.soft.config.persistance;

import com.arik.soft.infra.Profiles;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@Profile(Profiles.TEST)
@PropertySource("db-test.properties")
public class H2InMemoryConfig extends H2DataSourceConfig {

    @Value("${db.schema.name}")
    private String dbName;

    @Value("${hibernate.hbm2ddl.auto}")
    private String schemaOperation;

    @Override
    @Bean(destroyMethod = "shutdown")
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .setName(dbName)
                .build();
    }

    @Override
    @Bean
    public Properties jpaProperties() {
        Properties jpaProperties = new Properties();
        jpaProperties.setProperty("hibernate.hbm2ddl.auto", schemaOperation);
        return jpaProperties;
    }

}
