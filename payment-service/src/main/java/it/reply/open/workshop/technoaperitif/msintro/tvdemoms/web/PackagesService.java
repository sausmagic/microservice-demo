package it.reply.open.workshop.technoaperitif.msintro.tvdemoms.web;

import it.reply.open.workshop.technoaperitif.msintro.tvdemoms.data.CustomerPackagesRepository;
import it.reply.open.workshop.technoaperitif.msintro.tvdemoms.data.PackagesRepository;
import it.reply.open.workshop.technoaperitif.msintro.tvdemoms.model.CustomerPackage;
import it.reply.open.workshop.technoaperitif.msintro.tvdemoms.model.Package;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@RestController
@RequestMapping("/packages")
public class PackagesService {

    @Autowired
    private PackagesRepository packagesRepository;

    @Autowired
    private CustomerPackagesRepository customerPackagesRepository;

    @GetMapping("")
    public Collection<Package> getAllPackages() {
        return this.packagesRepository.findAll();
    }

    @GetMapping("/user/{userId}")
    public Collection<Package> getPackagesForUser(@PathVariable String userId) {
        return this.customerPackagesRepository.findByCustomerId(userId)
                                              .map(CustomerPackage::getPackages)
                                              .orElse(Collections.emptyList());
    }

    @PostMapping("/{packageCode}/user/{userId}")
    public void buyPackage(@NotNull @PathVariable String userId,
                           @NotNull @PathVariable String packageCode) {
        final CustomerPackage customerInfo = this.customerPackagesRepository.findByCustomerId(userId)
                                                                            .orElseGet(
                                                                                    () -> new CustomerPackage(null,
                                                                                                              userId,
                                                                                                              new ArrayList<>()));

        final Optional<Package> desiredPackage = this.packagesRepository.findByCode(packageCode);
        if (desiredPackage.isPresent()) {
            final Package pack = desiredPackage.get();
            if (!customerInfo.getPackages().contains(pack)) {
                customerInfo.getPackages().add(pack);
            }
            this.customerPackagesRepository.save(customerInfo);
        } else {
            throw new IllegalArgumentException("User " + userId + " or package " + packageCode + " don't exist");
        }
    }

}
