package it.reply.open.workshop.technoaperitif.msintro.tvdemoms.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.lang.NonNull;

import javax.annotation.Nonnull;
import javax.persistence.*;
import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Poll {

    @Id
    long id;

    @Column(nullable = false)
    String description;

    @OneToMany(targetEntity = PollOption.class)
    @JoinColumn(name = "pollid", nullable = false, insertable = false, updatable = false)
    @JsonIgnore
    List<PollOption> options;
}
