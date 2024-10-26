package tn.healthfit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
public class CommentaireApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommentaireApplication.class, args);
    }

}
