package it.reply.open.workshop.technoaperitif.msintro.tvdemoms.web;

import it.reply.open.workshop.technoaperitif.msintro.tvdemoms.bus.FidelityPointsGranter;
import it.reply.open.workshop.technoaperitif.msintro.tvdemoms.data.PrizesRepository;
import it.reply.open.workshop.technoaperitif.msintro.tvdemoms.data.UsersPointsRepository;
import it.reply.open.workshop.technoaperitif.msintro.tvdemoms.model.Prize;
import it.reply.open.workshop.technoaperitif.msintro.tvdemoms.model.UserPoints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/rewards")
public class FidelityService {

    @Autowired
    private PrizesRepository prizesRepository;

    @Autowired
    private UsersPointsRepository usersPointsRepository;

    @Autowired
    private FidelityPointsGranter granter;

    @GetMapping("")
    public Collection<Prize> getPrizeFor(@RequestParam(value = "collectableFrom", required = false) String userId) {
        if (userId == null) {
            return this.prizesRepository.findAll();
        } else {
            return this.usersPointsRepository.findById(userId)
                                   .map(userPoints -> this.prizesRepository.findByPointsNeededLessThanEqual(
                                           userPoints.getPoints()))
                                   .orElseThrow(() -> new IllegalArgumentException("User " + userId + " not found"));
        }
    }

    @GetMapping("/{prizeId}")
    public Prize getPrize(@PathVariable long prizeId) {
        return this.prizesRepository.findById(prizeId).orElseThrow(IllegalArgumentException::new);
    }

    @PutMapping("/{prizeId}")
    public void claimPrize(@PathVariable long prizeId,
                           @RequestParam(value = "claimedBy") String userId) {
        final Optional<UserPoints> possibleUser = this.usersPointsRepository.findById(userId);
        final Optional<Prize> possiblePrize = this.prizesRepository.findById(prizeId);

        if (possibleUser.isPresent() && possiblePrize.isPresent()) {
            final UserPoints user = possibleUser.get();
            final Prize prize = possiblePrize.get();

            if (user.getPoints() >= prize.getPointsNeeded() && prize.getAvailableInWarehouse() > 0) {
                prize.decrementAvailability();
                user.setPoints(user.getPoints() - prize.getPointsNeeded());

                this.prizesRepository.save(prize);

                this.granter.notifyPointsChange(user);
            } else {
                throw new IllegalArgumentException("User doesn't have enoough points or no more pieces in warehouse");
            }
        } else {
            throw new IllegalArgumentException("User " + userId + " or prize " + prizeId + " not found");
        }
    }

}