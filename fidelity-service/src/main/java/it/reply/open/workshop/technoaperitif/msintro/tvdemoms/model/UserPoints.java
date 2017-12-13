package it.reply.open.workshop.technoaperitif.msintro.tvdemoms.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Entity
public class UserPoints {

    @Id
    String userId;

    @Column(nullable = false)
    long points = 0L;

    @Version
    long version = 0L;

    public UserPoints(String userId, long points) {
        this.userId = userId;
        this.points = points;
        this.version = 0L;
    }
}
