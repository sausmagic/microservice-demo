package it.reply.open.workshop.technoaperitif.msintro.tvdemoms.data;

import it.reply.open.workshop.technoaperitif.msintro.tvdemoms.model.PollOption;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface PollOptionsRepository extends Repository<PollOption, Long> {

    Optional<PollOption> findById(PollOption.PollOptionId id);

    void save(PollOption option);
}
