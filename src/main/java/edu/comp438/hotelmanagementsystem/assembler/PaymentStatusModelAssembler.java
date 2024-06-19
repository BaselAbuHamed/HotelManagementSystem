package edu.comp438.hotelmanagementsystem.assembler;

import edu.comp438.hotelmanagementsystem.dto.PaymentStatusDTO;
import edu.comp438.hotelmanagementsystem.entity.PaymentStatus;
import edu.comp438.hotelmanagementsystem.controller.PaymentStatusController;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class PaymentStatusModelAssembler implements RepresentationModelAssembler<PaymentStatus, PaymentStatusDTO> {

    @Override
    @NonNull
    public PaymentStatusDTO toModel(@NonNull PaymentStatus paymentStatus) {
        PaymentStatusDTO paymentStatusDTO = new PaymentStatusDTO(
                paymentStatus.getId(),
                paymentStatus.getPaymentStatusName()
        );

        paymentStatusDTO.add(linkTo(methodOn(PaymentStatusController.class).getPaymentStatusById(paymentStatus.getId())).withSelfRel());
        return paymentStatusDTO;
    }
}
