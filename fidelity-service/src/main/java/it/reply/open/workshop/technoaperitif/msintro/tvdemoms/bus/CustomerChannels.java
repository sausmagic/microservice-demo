package it.reply.open.workshop.technoaperitif.msintro.tvdemoms.bus;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface CustomerChannels {
    String PAYMENT_EVENTS = "payment-events";
    String VOTING_EVENTS = "polls-events";

    @Input(PAYMENT_EVENTS)
    MessageChannel paymentNotifications();

    @Input(VOTING_EVENTS)
    MessageChannel votesNotifications();

    @Output("points-events")
    MessageChannel notifyPointsChange();
}
