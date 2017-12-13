package it.reply.open.workshop.technoaperitif.msintro.tvdemoms.bus;

import it.reply.open.workshop.technoaperitif.msintro.tvdemoms.data.UsersPointsRepository;
import it.reply.open.workshop.technoaperitif.msintro.tvdemoms.model.UserPoints;
import it.reply.open.workshop.technoaperitif.tvdemoms.bus.events.BillPayed;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class FidelityPointsGranter {

    @Autowired
    private UsersPointsRepository usersPointsRepository;

    @StreamListener(CustomersChannel.NAME)
    public void grantPointsToCustomers(BillPayed event){
        final UserPoints userPoints = this.usersPointsRepository.findById(event.getUserId()).orElseGet(() ->
                new UserPoints(event.getUserId(), 0L));
        userPoints.setPoints( userPoints.getPoints() + 100);
        usersPointsRepository.save(userPoints);
        log.info("Granted {} points to user {}", 100, event.getUserId());
    }
}
