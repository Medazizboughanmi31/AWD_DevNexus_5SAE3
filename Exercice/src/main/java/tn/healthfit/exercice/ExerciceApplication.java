package tn.healthfit.exercice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableDiscoveryClient
@SpringBootApplication
@EntityScan(basePackages = {"tn.healthfit.entities"})
@ComponentScan(basePackages = {"tn.healthfit.repositories","tn.healthfit.controllers","tn.healthfit.services"})
@EnableJpaRepositories(basePackages = "tn.healthfit.repositories")
@EnableAspectJAutoProxy
public class ExerciceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExerciceApplication.class, args);
	}

}
