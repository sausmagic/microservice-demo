package it.reply.open.workshop.technoaperitif.msintro.tvdemoms.collaborators;

import it.reply.open.workshop.technoaperitif.msintro.tvdemoms.collaborators.dto.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient("anag-service")
public interface AnagService {

    @GetMapping(value = "/users/{userId}", consumes = "application/json")
    Optional<User> findUser(@PathVariable("userId") String userId);
}
