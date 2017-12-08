package it.reply.open.workshop.technoaperitif.msintro.tvdemoms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
public class AnagServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnagServiceApplication.class, args);
	}
}
