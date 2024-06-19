package edu.comp438.hotelmanagementsystem.controller;

import edu.comp438.hotelmanagementsystem.dto.PaymentStatusDTO;
import edu.comp438.hotelmanagementsystem.service.PaymentStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/paymentstatus")
public class PaymentStatusController {

    private final PaymentStatusService paymentStatusService;

    @Autowired
    public PaymentStatusController(PaymentStatusService paymentStatusService) {
        this.paymentStatusService = paymentStatusService;
    }

    @PostMapping
    public ResponseEntity<PaymentStatusDTO> createPaymentStatus(@RequestBody PaymentStatusDTO paymentStatusDTO) {
        PaymentStatusDTO createdPaymentStatus = paymentStatusService.createPaymentStatus(paymentStatusDTO);
        return ResponseEntity.ok(createdPaymentStatus);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaymentStatusDTO> updatePaymentStatus(@PathVariable Long id, @RequestBody PaymentStatusDTO paymentStatusDTO) {
        PaymentStatusDTO updatedPaymentStatus = paymentStatusService.updatePaymentStatus(id, paymentStatusDTO);
        return ResponseEntity.ok(updatedPaymentStatus);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentStatusDTO> getPaymentStatusById(@PathVariable Long id) {
        PaymentStatusDTO paymentStatusDTO = paymentStatusService.getPaymentStatusById(id);
        return ResponseEntity.ok(paymentStatusDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaymentStatus(@PathVariable Long id) {
        paymentStatusService.deletePaymentStatus(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<PaymentStatusDTO>> getAllPaymentStatus() {
        List<PaymentStatusDTO> paymentStatusList = paymentStatusService.getAllPaymentStatuses();
        return ResponseEntity.ok(paymentStatusList);
    }
}
