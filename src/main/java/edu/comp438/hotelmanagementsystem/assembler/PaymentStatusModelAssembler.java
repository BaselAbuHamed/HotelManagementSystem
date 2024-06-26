package edu.comp438.hotelmanagementsystem.assembler;

import edu.comp438.hotelmanagementsystem.dto.PaymentStatusDTO;
import edu.comp438.hotelmanagementsystem.entity.PaymentStatus;
import edu.comp438.hotelmanagementsystem.controller.PaymentStatusController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class PaymentStatusModelAssembler implements RepresentationModelAssembler<PaymentStatus, EntityModel<PaymentStatusDTO>> {

    @Override
    @NonNull
    public EntityModel<PaymentStatusDTO> toModel(@NonNull PaymentStatus paymentStatus) {
        PaymentStatusDTO paymentStatusDTO = new PaymentStatusDTO(
                paymentStatus.getId(),
                paymentStatus.getPaymentStatusName()
        );

        EntityModel<PaymentStatusDTO> paymentStatusEntityModel = EntityModel.of(paymentStatusDTO);
        paymentStatusEntityModel.add(linkTo(methodOn(PaymentStatusController.class).getPaymentStatusById(paymentStatus.getId())).withSelfRel());
        return paymentStatusEntityModel;
    }
}
