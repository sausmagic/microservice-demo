package it.reply.open.workshop.technoaperitif.msintro.tvdemoms.collaborators.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class User {

    String userid;
    String name;
    int earnedPoints = 0;
}
