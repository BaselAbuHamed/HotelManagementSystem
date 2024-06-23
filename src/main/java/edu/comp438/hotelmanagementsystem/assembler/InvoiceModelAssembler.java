package edu.comp438.hotelmanagementsystem.assembler;

import edu.comp438.hotelmanagementsystem.dto.InvoiceDTO;
import edu.comp438.hotelmanagementsystem.entity.Invoice;
import edu.comp438.hotelmanagementsystem.controller.InvoiceController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class InvoiceModelAssembler implements RepresentationModelAssembler<Invoice, EntityModel<InvoiceDTO> >{

    @Override
    @NonNull
    public EntityModel<InvoiceDTO> toModel(@NonNull Invoice invoice) {
        InvoiceDTO invoiceDTO = new InvoiceDTO(
                invoice.getId(),
                invoice.getBooking().getId(),
                invoice.getAmount(),
                invoice.getInvoiceDate(),
                invoice.getPaid()
        );

        EntityModel<InvoiceDTO> invoiceEntityModel = EntityModel.of(invoiceDTO);
        invoiceEntityModel.add(linkTo(methodOn(InvoiceController.class).getInvoiceById(invoice.getId())).withSelfRel());
        return invoiceEntityModel;
    }
}
