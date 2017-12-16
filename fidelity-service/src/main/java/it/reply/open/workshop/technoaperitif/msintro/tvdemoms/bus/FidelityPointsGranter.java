package it.reply.open.workshop.technoaperitif.msintro.tvdemoms.bus;

import it.reply.open.workshop.technoaperitif.msintro.tvdemoms.data.UsersPointsRepository;
import it.reply.open.workshop.technoaperitif.msintro.tvdemoms.model.UserPoints;
import it.reply.open.workshop.technoaperitif.tvdemoms.bus.events.BillPayed;
import it.reply.open.workshop.technoaperitif.tvdemoms.bus.events.FidelityPointsGranted;
import it.reply.open.workshop.technoaperitif.tvdemoms.bus.events.VotedInPoll;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.support.DefaultMessageBuilderFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class FidelityPointsGranter {

    @Autowired
    private CustomerChannels customerChannels;

    @Autowired
    private UsersPointsRepository usersPointsRepository;

    @Value("${tvapp.fidelity.grantPoints.forPaying:0}")
    private int pointsForPaying;

    @Value("${tvapp.fidelity.grantPoints.forVoting:0}")
    private int pointsForVoting;

    @StreamListener(CustomerChannels.PAYMENT_EVENTS)
    public void grantPointsToCustomers(BillPayed event) {
        grantPointsTo(event.getUserId(), pointsForPaying);
    }

    @StreamListener(CustomerChannels.VOTING_EVENTS)
    public void grantPointsToCustomers(VotedInPoll event) {
        grantPointsTo(event.getUserId(), pointsForVoting);
    }

    private void grantPointsTo(String userId, int amount) {
        final UserPoints userPoints = this.usersPointsRepository.findById(userId).orElseGet(() -> new UserPoints(userId, 0));
        userPoints.setPoints(userPoints.getPoints() + amount);
        usersPointsRepository.save(userPoints);

        log.info("Granted {} points to user {}", amount, userId);

        notifyPointsChange(userPoints);
    }

    public void notifyPointsChange(UserPoints userPoints) {
        this.customerChannels.notifyPointsChange().send(
                new DefaultMessageBuilderFactory().withPayload(
                        new FidelityPointsGranted(userPoints.getUserId(), userPoints.getPoints())
                ).build()
        );
    }
}
