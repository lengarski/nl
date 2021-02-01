package eu.lengarski.nlpostcode.beans;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Configuration
@Component
public class DataSourceBean {

    private static Logger logger = LoggerFactory.getLogger(DataSourceBean.class);
    @Value("${DB_HOST:unset}") 
    private String dbHost;

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    @Primary
    public DataSource getDataSource() {

        logger.info("##  DB_HOST = " + dbHost);
        return DataSourceBuilder.create().url("jdbc:mysql://" + dbHost + ":3306/nlpc").username("nlpc").password("nlpc")
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .build();
    }
}

