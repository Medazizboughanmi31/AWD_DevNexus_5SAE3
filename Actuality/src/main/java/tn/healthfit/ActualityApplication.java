package tn.healthfit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ActualityApplication {
    public static void main(String[] args) {
        SpringApplication.run(ActualityApplication.class, args);
    }
}