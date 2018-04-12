package com.yulintu.thematic.example.provider;


import com.yulintu.thematic.data.hibernate.HibernateConnectionStringBuilder;
import com.yulintu.thematic.data.hibernate.ProviderPersistence;
import com.yulintu.thematic.data.hibernate.ProviderPersistenceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BeanConfiguration {

    @Bean
    @Scope("prototype")
    public ProviderPersistence provider() {

        HibernateConnectionStringBuilder builder = new HibernateConnectionStringBuilder();
        builder.setConfigureFilePath("hibernate.sqlserver.cfg.xml");

        return new ProviderPersistenceImpl(builder.getConnectionString());
    }
}
