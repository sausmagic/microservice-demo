package it.reply.open.workshop.technoaperitif.msintro.tvdemoms.web;

import it.reply.open.workshop.technoaperitif.msintro.tvdemoms.data.PollOptionsRepository;
import it.reply.open.workshop.technoaperitif.msintro.tvdemoms.data.PollsRepository;
import it.reply.open.workshop.technoaperitif.msintro.tvdemoms.model.Poll;
import it.reply.open.workshop.technoaperitif.msintro.tvdemoms.model.PollOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/polls")
public class VotesService {

    @Autowired
    private PollsRepository pollsRepository;

    @Autowired
    private PollOptionsRepository pollOptionsRepository;

    @Value("${tvapp.fedelity.grant-points.forVoting:0}")
    private int fidelityPointsForVoting;

    @GetMapping("")
    public Collection<Poll> getPollsList() {
        return this.pollsRepository.findAll();
    }

    @GetMapping("/{pollNumber}")
    public Poll getPoll(@PathVariable long pollNumber) {
        return this.pollsRepository.findById(pollNumber).orElseThrow(IllegalArgumentException::new);
    }

    @GetMapping("/{pollNumber}/options")
    public List<PollOption> getPollOptions(@PathVariable long pollNumber) {
        return this.pollsRepository.findById(pollNumber)
                                   .map(Poll::getOptions)
                                   .orElseThrow(IllegalArgumentException::new);
    }

    @GetMapping("/{pollNumber}/options/{optionId}")
    public PollOption getPollOptions(@PathVariable long pollNumber, @PathVariable long optionId) {
        return this.pollOptionsRepository.findById(new PollOption.PollOptionId(pollNumber, optionId))
                                         .orElseThrow(IllegalArgumentException::new);
    }

    @PostMapping("/{pollNumber}/options/{optionId}/{userId}")
    public void vote(@PathVariable long pollNumber, @PathVariable long optionId, @PathVariable String userId) {
        // TODO check anag-service for userId
        final Optional<PollOption> pollOption =
                this.pollOptionsRepository.findById(new PollOption.PollOptionId(pollNumber, optionId));
        if (pollOption.isPresent()) {
            final PollOption existentPollOption = pollOption.get();
            existentPollOption.setVotes(existentPollOption.getVotes() + 1);
            this.pollOptionsRepository.save(existentPollOption);

            // TODO grant points for voting
        } else {
            throw new IllegalArgumentException("Option " + optionId + " for poll " + pollNumber + " not found");
        }
    }
}