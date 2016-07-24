package org.sertech.maroma.config;

import org.sertech.maroma.audit.AuditorAwareBean;
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
@EnableJpaRepositories(basePackages = {"org.sertech.maroma"})
@EnableTransactionManagement
@EnableJpaAuditing
public class AppConfig {
    @Bean
    public AuditorAware<String> auditorProvider() {
        return new AuditorAwareBean();
    }
}
