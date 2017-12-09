package it.reply.open.workshop.technoaperitif.msintro.tvdemoms.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

import java.math.BigDecimal;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Package {

    @Id
    String id;

    @NonNull
    String code = "";

    @NonNull
    String name = "";

    @NonNull
    String description = "";

    @NonNull
    BigDecimal price = BigDecimal.ZERO;

}

