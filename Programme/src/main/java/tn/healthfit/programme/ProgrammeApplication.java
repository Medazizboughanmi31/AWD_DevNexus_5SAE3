package tn.healthfit.programme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"tn.healthfit.entities"})
@ComponentScan(basePackages = {"tn.healthfit.repositories","tn.healthfit.controllers","tn.healthfit.services"})
@EnableJpaRepositories(basePackages = "tn.healthfit.repositories")
@EnableAspectJAutoProxy
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "tn.healthfit")
public class ProgrammeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProgrammeApplication.class, args);
	}

}
