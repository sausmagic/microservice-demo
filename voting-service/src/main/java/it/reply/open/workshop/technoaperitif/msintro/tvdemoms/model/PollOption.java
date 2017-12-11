package it.reply.open.workshop.technoaperitif.msintro.tvdemoms.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.annotation.Nonnull;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PollOption {

    @Data
    @FieldDefaults(level = AccessLevel.PRIVATE)
    @NoArgsConstructor
    @AllArgsConstructor
    @Embeddable
    public static class PollOptionId implements Serializable{
        @Column(name = "pollid")
        long pollId;

        @Column(name = "id")
        long optionId;
    }

    @EmbeddedId
    PollOptionId id;

    @Column(nullable = false)
    @Nonnull
    String description;

    @Column(nullable = false)
    int votes = 0;
}
