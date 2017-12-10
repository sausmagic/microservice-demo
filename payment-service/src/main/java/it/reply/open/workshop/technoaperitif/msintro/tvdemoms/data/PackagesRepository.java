package it.reply.open.workshop.technoaperitif.msintro.tvdemoms.data;

import it.reply.open.workshop.technoaperitif.msintro.tvdemoms.model.Package;
import org.springframework.data.repository.Repository;

import java.util.Collection;
import java.util.Optional;

public interface PackagesRepository extends Repository<Package, String> {
    Optional<Package> findByCode(String code);

    Collection<Package> findAll();

    Package save(Package unsaved);
}
