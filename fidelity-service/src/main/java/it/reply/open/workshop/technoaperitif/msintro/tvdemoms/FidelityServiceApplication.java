package it.reply.open.workshop.technoaperitif.msintro.tvdemoms;

import it.reply.open.workshop.technoaperitif.msintro.tvdemoms.bus.CustomerChannels;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableFeignClients
@EnableBinding(CustomerChannels.class)
public class FidelityServiceApplication {

    public static void main(String[] args) {
        new SpringApplication(FidelityServiceApplication.class).run(args);
    }
}
