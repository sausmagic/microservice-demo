package it.reply.open.workshop.technoaperitif.msintro.tvdemoms.outer;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class EdgeServerApp {

    public static void main(String[] args) {
        new SpringApplicationBuilder(EdgeServerApp.class).web(WebApplicationType.SERVLET).run(args);
    }
}
