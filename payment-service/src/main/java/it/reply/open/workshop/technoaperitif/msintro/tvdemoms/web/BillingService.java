package it.reply.open.workshop.technoaperitif.msintro.tvdemoms.web;

import it.reply.open.workshop.technoaperitif.msintro.tvdemoms.data.BillingsRepository;
import it.reply.open.workshop.technoaperitif.msintro.tvdemoms.data.CustomerPackagesRepository;
import it.reply.open.workshop.technoaperitif.msintro.tvdemoms.model.Bill;
import it.reply.open.workshop.technoaperitif.msintro.tvdemoms.model.CustomerPackage;
import it.reply.open.workshop.technoaperitif.msintro.tvdemoms.model.Package;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/billings")
public class BillingService {

    @Autowired
    private CustomerPackagesRepository customerPackagesRepository;

    @Autowired
    private BillingsRepository billingsRepository;

    @GetMapping("/{billId}")
    public Bill getBill(@PathVariable String billId) {
        return this.billingsRepository.findById(billId).orElseThrow(IllegalArgumentException::new);
    }

    @PostMapping("")
    public Collection<String> generateTodayBillings() {
        final List<CustomerPackage> allCustomers = this.customerPackagesRepository.findAll();

        final List<String> billsId = new ArrayList<>(allCustomers.size());
        for (final CustomerPackage customer : allCustomers) {
            final Bill bill = this.billingsRepository.save(new Bill(null, LocalDate.now(), customer.getCustomerId(),
                                                                    customer.getPackages()
                                                                            .stream()
                                                                            .map(Package::getPrice)
                                                                            .reduce(BigDecimal.ZERO, BigDecimal::add),
                                                                    false
            ));
            billsId.add(bill.getId());
        }
        return billsId;
    }

    @PutMapping("/{billId}")
    public void updateBill(@PathVariable String billId, @RequestBody Bill billData) {
        if (!(null != billData.getId() && billData.getId().equals(billId))) {
            throw new IllegalArgumentException("Bill number " + billId + " doesn't match body data");
        }

        final Optional<Bill> bill = this.billingsRepository.findById(billId);
        if (bill.isPresent()) {
            final Bill payedBill = bill.get();
            final boolean wasAlreadyPayed = payedBill.isPayed();
            payedBill.setPayed(billData.isPayed());
            this.billingsRepository.save(payedBill);

            // if a new bill has been payed, grant the user some points.
            if (!wasAlreadyPayed && payedBill.isPayed()) {
                // TODO Assign points for paying bills
            }
        } else {
            throw new IllegalArgumentException("Bill " + billId + " not found.");
        }
    }
}