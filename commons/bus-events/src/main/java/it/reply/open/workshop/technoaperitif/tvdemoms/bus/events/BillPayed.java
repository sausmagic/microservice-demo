package it.reply.open.workshop.technoaperitif.tvdemoms.bus.events;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BillPayed {

    String userId;
    String billId;

    Instant paymentDate = Instant.now();
}
