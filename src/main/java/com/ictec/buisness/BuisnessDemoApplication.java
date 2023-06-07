package com.ictec.buisness;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BuisnessDemoApplication {
    @Value("${type}")
    String type;

    public static void main(String[] args) {
        SpringApplication.run(BuisnessDemoApplication.class, args);
    }

    @Bean
    public URLConfig createURLConfigOb(){
        if(this.type.equals("local")){
            return new URLConfig("http", "localhost", "8080");
        }else{
            return new URLConfig("https", "ictec.com");
        }
    }
}
