package it.reply.open.workshop.technoaperitif.msintro.tvdemoms.data;

import it.reply.open.workshop.technoaperitif.msintro.tvdemoms.model.Package;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface PackagesRepository extends MongoRepository<Package, String> {
    Optional<Package> findByCode(String code);
}
