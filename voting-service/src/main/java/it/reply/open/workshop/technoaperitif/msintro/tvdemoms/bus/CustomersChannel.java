package it.reply.open.workshop.technoaperitif.msintro.tvdemoms.bus;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;

public interface CustomersChannel {
    String NAME = "polls-events";

    @Output(NAME)
    SubscribableChannel notifyVotes();
}
