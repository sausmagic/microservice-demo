package it.reply.open.workshop.technoaperitif.msintro.tvdemoms.data;

import it.reply.open.workshop.technoaperitif.msintro.tvdemoms.model.CustomerPackage;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface CustomerPackagesRepository extends Repository<CustomerPackage, String> {

    Optional<CustomerPackage> findByCustomerId(String customerId);

    List<CustomerPackage> findAll();

    CustomerPackage save(CustomerPackage customerInfo);
}
