package edu.comp438.hotelmanagementsystem.mapper;

import edu.comp438.hotelmanagementsystem.dto.InvoiceDTO;
import edu.comp438.hotelmanagementsystem.entity.Booking;
import edu.comp438.hotelmanagementsystem.entity.Invoice;
import edu.comp438.hotelmanagementsystem.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InvoiceMapper {

    private final BookingRepository bookingRepository;

    @Autowired
    public InvoiceMapper(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public InvoiceDTO toDto(Invoice invoice) {
        return new InvoiceDTO(
                invoice.getId(),
                invoice.getBooking().getId(),
                invoice.getAmount(),
                invoice.getInvoiceDate(),
                invoice.getPaid()
        );
    }

    public Invoice toEntity(InvoiceDTO invoiceDTO) {
        Invoice invoice = new Invoice();
        invoice.setId(invoiceDTO.getId());

        Booking booking = bookingRepository.findById(invoiceDTO.getBookingId())
                .orElseThrow(() -> new RuntimeException("Booking not found with id: " + invoiceDTO.getBookingId()));
        invoice.setBooking(booking);

        invoice.setAmount(invoiceDTO.getAmount());
        invoice.setInvoiceDate(invoiceDTO.getInvoiceDate());
        invoice.setPaid(invoiceDTO.getPaid());

        return invoice;
    }
}
