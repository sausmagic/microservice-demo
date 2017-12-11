package it.reply.open.workshop.technoaperitif.msintro.tvdemoms.data;

import it.reply.open.workshop.technoaperitif.msintro.tvdemoms.model.Bill;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface BillingsRepository extends Repository<Bill, String> {

    Optional<Bill> findById(String id);

    Bill save(Bill unsaved);
}
