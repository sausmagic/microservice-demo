package it.reply.open.workshop.technoaperitif.msintro.tvdemoms.outer;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceDiscoveryServerApp {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ServiceDiscoveryServerApp.class).web(WebApplicationType.SERVLET).run(args);
    }
}
