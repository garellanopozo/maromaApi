package org.sertech.maroma;

import org.sertech.maroma.rest.MaromaRestController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by German on 28/07/2016.
 */
@SpringBootApplication
@ComponentScan(basePackageClasses = MaromaRestController.class)
public class MaromaSoaApplication {
    public static void main(String[] args) {
        SpringApplication.run(MaromaSoaApplication.class, args);
    }
}
