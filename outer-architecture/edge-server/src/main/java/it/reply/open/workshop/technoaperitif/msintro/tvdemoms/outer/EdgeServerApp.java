package it.reply.open.workshop.technoaperitif.msintro.tvdemoms.outer;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EdgeServerApp {

    public static void main(String[] args) {
        new SpringApplicationBuilder(EdgeServerApp.class).web(WebApplicationType.REACTIVE).run(args);
    }

    @Bean
    public DiscoveryClientRouteDefinitionLocator discoveryClientRouteLocator(DiscoveryClient discoveryClient) {
        return new DiscoveryClientRouteDefinitionLocator(discoveryClient);
    }
}
