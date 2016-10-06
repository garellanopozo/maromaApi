package org.sertech.maroma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
/**
 * Created by German on 28/07/2016.
 */
@SpringBootApplication
@ComponentScan(basePackages={"org.sertech.maroma.component"})
public class MaromaSoaApplication {
    public static void main(String[] args) {
        SpringApplication.run(MaromaSoaApplication.class, args);
    }
}
