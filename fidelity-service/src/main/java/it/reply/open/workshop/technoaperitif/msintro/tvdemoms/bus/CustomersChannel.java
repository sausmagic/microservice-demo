package it.reply.open.workshop.technoaperitif.msintro.tvdemoms.bus;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface CustomersChannel {
    String NAME = "customer-events";

    @Input(NAME)
    MessageChannel notifyPayments();
}
