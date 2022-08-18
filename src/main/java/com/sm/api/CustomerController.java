package com.sm.api;

import com.sm.model.Customer;
import com.sm.model.Order;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    @Autowired
    private KieSession session;

    @PostMapping("/customer/offer")
    public Customer getNewCustomerOfferDetails(@RequestBody Customer customer) {
        session.insert(customer);
        session.fireAllRules();
        return customer;
    }

}
