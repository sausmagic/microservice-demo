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
import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Bill {

    @Id
    String id;

    @NonNull
    LocalDate date = LocalDate.now();

    @NonNull
    String customerId = "";

    @NonNull
    BigDecimal amount = BigDecimal.ZERO;

    @NonNull
    boolean payed = false;
}

