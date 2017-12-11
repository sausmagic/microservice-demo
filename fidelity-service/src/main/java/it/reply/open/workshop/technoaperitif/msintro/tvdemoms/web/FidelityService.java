package it.reply.open.workshop.technoaperitif.msintro.tvdemoms.web;

import it.reply.open.workshop.technoaperitif.msintro.tvdemoms.collaborators.AnagService;
import it.reply.open.workshop.technoaperitif.msintro.tvdemoms.collaborators.dto.User;
import it.reply.open.workshop.technoaperitif.msintro.tvdemoms.data.PrizesRepository;
import it.reply.open.workshop.technoaperitif.msintro.tvdemoms.model.Prize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/rewards")
public class FidelityService {

    @Autowired
    private AnagService anagService;

    @Autowired
    private PrizesRepository prizesRepository;

    @GetMapping("")
    public Collection<Prize> getPrizeFor(@RequestParam(value = "collectableFrom", required = false) String userId) {
        if (userId == null) {
            return this.prizesRepository.findAll();
        } else {
            return this.anagService.findUser(userId)
                                   .map(user -> this.prizesRepository.findByPointsNeededLessThanEqual(
                                           user.getEarnedPoints()))
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
        final Optional<User> possibleUser = this.anagService.findUser(userId);
        final Optional<Prize> possiblePrize = this.prizesRepository.findById(prizeId);

        if (possibleUser.isPresent() && possiblePrize.isPresent()) {
            final User user = possibleUser.get();
            final Prize prize = possiblePrize.get();

            if (user.getEarnedPoints() >= prize.getPointsNeeded() && prize.getAvailableInWarehouse() > 0) {
                prize.decrementAvailability();
                user.setEarnedPoints(user.getEarnedPoints() - prize.getPointsNeeded());

                this.prizesRepository.save(prize);
                // TODO decrement user points for claimed prize
            } else {
                throw new IllegalArgumentException("User doesn't have enoough points or no more pieces in warehouse");
            }
        } else {
            throw new IllegalArgumentException("User " + userId + " or prize " + prizeId + " not found");
        }
    }

}