package it.reply.open.workshop.technoaperitif.msintro.tvdemoms;

import it.reply.open.workshop.technoaperitif.msintro.tvdemoms.bus.CustomersChannel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding(CustomersChannel.class)
public class AnagServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnagServiceApplication.class, args);
	}
}
