package it.reply.open.workshop.technoaperitif.msintro.tvdemoms.web;

import it.reply.open.workshop.technoaperitif.msintro.tvdemoms.data.UsersRepository;
import it.reply.open.workshop.technoaperitif.msintro.tvdemoms.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Nonnull;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@RestController
@RequestMapping("/")
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
}
