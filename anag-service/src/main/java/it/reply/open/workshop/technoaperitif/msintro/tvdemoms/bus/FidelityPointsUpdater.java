package it.reply.open.workshop.technoaperitif.msintro.tvdemoms.bus;

import it.reply.open.workshop.technoaperitif.msintro.tvdemoms.data.UsersRepository;
import it.reply.open.workshop.technoaperitif.msintro.tvdemoms.model.User;
import it.reply.open.workshop.technoaperitif.tvdemoms.bus.events.FidelityPointsGranted;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
public class FidelityPointsUpdater {

    @Autowired
    private UsersRepository usersRepository;

    @StreamListener(CustomersChannel.NAME)
    public void updateCustomerPoints(FidelityPointsGranted event){
        final Optional<User> targetUser = this.usersRepository.findByUserid(event.getUserId());
        if (targetUser.isPresent()) {
            User user = targetUser.get();
            user.setEarnedPoints(event.getNewTotal());
            usersRepository.save(user);

            log.info("Updated points total for user {} to {}", event.getUserId(), event.getNewTotal());
        } else {
            log.warn("User {} not found", event.getUserId());
        }
    }
}
