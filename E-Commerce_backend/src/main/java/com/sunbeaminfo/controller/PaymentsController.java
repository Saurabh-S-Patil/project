package com.sunbeaminfo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeaminfo.entities.Payments;
import com.sunbeaminfo.service.PaymentService;

@RestController
@RequestMapping("/api/payments")
public class PaymentsController {

    @Autowired
    private PaymentService paymentsService;

    @PostMapping
    public Payments createPayment(@RequestBody Payments payment) {
        return paymentsService.createPayment(payment);
    }

    @GetMapping("/{id}")
    public Payments getPayment(@PathVariable Long id) {
        return paymentsService.getPaymentById(id);
    }

    @GetMapping
    public List<Payments> getAllPayments() {
        return paymentsService.getAllPayments();
    }

    @PutMapping("/{id}")
    public Payments updatePayment(@PathVariable Long id, @RequestBody Payments payment) {
        return paymentsService.updatePayment(id, payment);
    }

    @DeleteMapping("/{id}")
    public void deletePayment(@PathVariable Long id) {
        paymentsService.deletePayment(id);
    }
}
