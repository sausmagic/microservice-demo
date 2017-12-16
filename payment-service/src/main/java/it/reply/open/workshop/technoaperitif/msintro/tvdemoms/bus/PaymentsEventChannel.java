package it.reply.open.workshop.technoaperitif.msintro.tvdemoms.bus;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface PaymentsEventChannel {
    String NAME = "payment-events";

    @Output(NAME)
    MessageChannel notifyPayments();
}
