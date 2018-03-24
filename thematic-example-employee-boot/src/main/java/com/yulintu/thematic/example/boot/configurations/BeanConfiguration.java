package com.yulintu.thematic.example.boot.configurations;

import com.yulintu.thematic.data.*;
import com.yulintu.thematic.data.hibernate.HibernateConnectionStringBuilder;
import com.yulintu.thematic.data.hibernate.ProviderHibernateImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
@ImportResource("spring.application.xml")
public class BeanConfiguration extends SpringConfiguration {

    public BeanConfiguration() {
    }

    @Value("${thematic.datasource.name}")
    private String dsConfigName;

    @Bean
    @Scope("prototype")
    public Provider provider() {
        HibernateConnectionStringBuilder builder = new HibernateConnectionStringBuilder();
        builder.setConfigureFilePath(dsConfigName);
        return new ProviderHibernateImpl(builder.getConnectionString());
    }
}
