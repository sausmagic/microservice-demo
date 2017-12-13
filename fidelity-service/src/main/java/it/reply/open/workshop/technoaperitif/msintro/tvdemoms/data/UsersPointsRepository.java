package it.reply.open.workshop.technoaperitif.msintro.tvdemoms.data;

import it.reply.open.workshop.technoaperitif.msintro.tvdemoms.model.UserPoints;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface UsersPointsRepository extends Repository<UserPoints, String> {

    Optional<UserPoints> findById(String userId);

    UserPoints save(UserPoints unsaved);
}
