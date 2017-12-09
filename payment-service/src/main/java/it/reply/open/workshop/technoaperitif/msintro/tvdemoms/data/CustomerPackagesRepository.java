package it.reply.open.workshop.technoaperitif.msintro.tvdemoms.data;

import it.reply.open.workshop.technoaperitif.msintro.tvdemoms.model.CustomerPackage;
import it.reply.open.workshop.technoaperitif.msintro.tvdemoms.model.Package;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.Repository;

import java.util.Collection;
import java.util.Optional;

public interface CustomerPackagesRepository extends MongoRepository<CustomerPackage, String> {

    Optional<CustomerPackage> findByCustomerId(String customerId);

}
