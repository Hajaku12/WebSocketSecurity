package co.edu.escuelaing.arsw.bbapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application.properties")
public class BBAppStarter {

    public static void main(String[] args) {
        SpringApplication.run(BBAppStarter.class, args);
    }
}
