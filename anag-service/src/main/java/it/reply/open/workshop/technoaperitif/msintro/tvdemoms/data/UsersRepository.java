package it.reply.open.workshop.technoaperitif.msintro.tvdemoms.data;

import it.reply.open.workshop.technoaperitif.msintro.tvdemoms.model.User;
import org.springframework.data.repository.Repository;

import java.util.Collection;
import java.util.Optional;

public interface UsersRepository extends Repository<User, String> {

    Collection<User> findAll();

    Optional<User> findByUserid(String id);

    void save(User user);
}
