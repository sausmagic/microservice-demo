package it.reply.open.workshop.technoaperitif.msintro.tvdemoms;

import it.reply.open.workshop.technoaperitif.msintro.tvdemoms.bus.CustomersChannel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableFeignClients
@EnableBinding(CustomersChannel.class)
public class VotingServiceApplication {

    public static void main(String[] args) {
        new SpringApplication(VotingServiceApplication.class).run(args);
    }
}
