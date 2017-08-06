package com.arik.soft.config.persistance;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({H2InMemoryConfig.class, H2FileBasedConfig.class, PostgresDatabaseConfig.class})
public class DataSourcePortfolioConfig {
}
