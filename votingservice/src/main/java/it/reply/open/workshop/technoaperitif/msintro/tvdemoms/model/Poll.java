package it.reply.open.workshop.technoaperitif.msintro.tvdemoms.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

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
    @Nonnull
    long id;

    @Column(nullable = false)
    @Nonnull
    String description;

    @OneToMany(targetEntity = PollOption.class)
    @JoinColumn(name = "pollid", nullable = false, insertable = false, updatable = false)
    @Nonnull
    @JsonIgnore
    List<PollOption> options;
}
