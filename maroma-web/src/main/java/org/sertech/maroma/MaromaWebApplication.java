package org.sertech.maroma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Created by German on 28/07/2016.
 */
@SpringBootApplication
public class MaromaWebApplication extends SpringBootServletInitializer {
    private static Class<MaromaWebApplication> applicationClass = MaromaWebApplication.class;

    public static void main(String[] args) {
        SpringApplication.run(applicationClass, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(applicationClass);
    }
}
