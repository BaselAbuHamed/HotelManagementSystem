package edu.comp438.hotelmanagementsystem.service;

import edu.comp438.hotelmanagementsystem.dto.PaymentStatusDTO;
import java.util.List;

public interface PaymentStatusService {
    PaymentStatusDTO createPaymentStatus(PaymentStatusDTO paymentStatusDTO);
    PaymentStatusDTO updatePaymentStatus(Long id, PaymentStatusDTO paymentStatusDTO);
    PaymentStatusDTO getPaymentStatusById(Long id);
    void deletePaymentStatus(Long id);
    List<PaymentStatusDTO> getAllPaymentStatuses();
}
