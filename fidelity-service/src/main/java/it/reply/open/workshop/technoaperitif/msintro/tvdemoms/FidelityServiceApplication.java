package it.reply.open.workshop.technoaperitif.msintro.tvdemoms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FidelityServiceApplication {

    public static void main(String[] args) {
        new SpringApplication(FidelityServiceApplication.class).run(args);
    }
}
