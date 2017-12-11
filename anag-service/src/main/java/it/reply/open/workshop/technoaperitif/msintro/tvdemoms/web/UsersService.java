package it.reply.open.workshop.technoaperitif.msintro.tvdemoms.web;

import com.google.common.base.Strings;
import it.reply.open.workshop.technoaperitif.msintro.tvdemoms.data.UsersRepository;
import it.reply.open.workshop.technoaperitif.msintro.tvdemoms.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Nonnull;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Nonnull
    @GetMapping("")
    public Collection<User> getAllUsers() {
        return this.usersRepository.findAll();
    }

    @GetMapping("/{userId}")
    public User getUser(@NotNull @PathVariable String userId) {
        return this.usersRepository.findByUserid(userId).orElseThrow(IllegalArgumentException::new);
    }

    @PutMapping("/{userId}")
    public void grantPoints(@NotNull @PathVariable String userId,
                            @NotNull @RequestBody User userData) {
        //noinspection PointlessBooleanExpression
        if (Strings.isNullOrEmpty(userId) || userId.equals(userData.getUserid()) == false) {
            throw new IllegalArgumentException("User id " + userId + " not matching with request body");
        }

        final Optional<User> user = this.usersRepository.findByUserid(userId);
        if (user.isPresent()) {
            final User updated = user.get();
            updated.setEarnedPoints(userData.getEarnedPoints());
            this.usersRepository.save(updated);
        }
    }
}
