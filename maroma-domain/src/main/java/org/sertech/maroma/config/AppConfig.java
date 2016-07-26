package org.sertech.maroma.config;

import org.sertech.maroma.audit.AuditorAwareBean;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by German on 24/07/2016.
 */
@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"org.sertech.maroma.domain"})
@EnableJpaRepositories(basePackages = {"org.sertech.maroma.repository"})
@EnableTransactionManagement
@EnableJpaAuditing
public class AppConfig {
    @Bean
    public AuditorAware<String> auditorProvider() {
        return new AuditorAwareBean();
    }
}
