package it.reply.open.workshop.technoaperitif.msintro.tvdemoms.data;

import it.reply.open.workshop.technoaperitif.msintro.tvdemoms.model.Poll;
import org.springframework.data.repository.Repository;

import java.util.Collection;
import java.util.Optional;

public interface PollsRepository extends Repository<Poll, Long> {

    Collection<Poll> findAll();

    Optional<Poll> findById(long id);

}
