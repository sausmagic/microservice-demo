package it.reply.open.workshop.technoaperitif.msintro.tvdemoms.data;

import it.reply.open.workshop.technoaperitif.msintro.tvdemoms.model.Prize;
import org.springframework.data.repository.Repository;

import java.util.Collection;
import java.util.Optional;

public interface PrizesRepository extends Repository<Prize, Long> {

    Collection<Prize> findAll();

    Optional<Prize> findById(long id);

    Collection<Prize> findByPointsNeededLessThanEqual(int threshold);

    void save(Prize prize);
}
