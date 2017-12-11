package it.reply.open.workshop.technoaperitif.msintro.tvdemoms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class VotingServiceApplication {

    public static void main(String[] args) {
        new SpringApplication(VotingServiceApplication.class).run(args);
    }
}
