package com.TP_ESEO_Maven2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(Application.class, args);
        log.info("Application demaree !");
    }
}
