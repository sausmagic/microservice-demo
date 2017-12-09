package it.reply.open.workshop.technoaperitif.msintro.tvdemoms.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

import java.util.Collection;
import java.util.Collections;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Document
public class CustomerPackage {

    @Id
    String id;

    @NonNull
    String customerId = "";

    @NonNull
    Collection<Package> packages = Collections.emptyList();
}

