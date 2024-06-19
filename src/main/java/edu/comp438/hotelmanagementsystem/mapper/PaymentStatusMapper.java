package edu.comp438.hotelmanagementsystem.mapper;

import edu.comp438.hotelmanagementsystem.dto.PaymentStatusDTO;
import edu.comp438.hotelmanagementsystem.entity.PaymentStatus;
import org.springframework.stereotype.Component;

@Component
public class PaymentStatusMapper {

    public PaymentStatusDTO toDto(PaymentStatus paymentStatus) {
        return new PaymentStatusDTO(
                paymentStatus.getId(),
                paymentStatus.getPaymentStatusName()
        );
    }

    public PaymentStatus toEntity(PaymentStatusDTO paymentStatusDTO) {
        PaymentStatus paymentStatus = new PaymentStatus();
        paymentStatus.setId(paymentStatusDTO.getId());
        paymentStatus.setPaymentStatusName(paymentStatusDTO.getPaymentStatusName());
        return paymentStatus;
    }
}
