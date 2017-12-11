package it.reply.open.workshop.technoaperitif.msintro.tvdemoms.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.annotation.Nonnull;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Prize {

    @Id
    long id;

    @Column(nullable = false)
    @Nonnull
    String description;

    @Column(nullable = false)
    int pointsNeeded;

    @Column(nullable = false)
    int availableInWarehouse;

    @Version
    long version;

    public void decrementAvailability() {
        --this.availableInWarehouse;
    }
}

