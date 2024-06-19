package edu.comp438.hotelmanagementsystem.service;

import edu.comp438.hotelmanagementsystem.dto.InvoiceDTO;
import java.util.List;

public interface InvoiceService {
    InvoiceDTO createInvoice(InvoiceDTO invoiceDTO);
    InvoiceDTO updateInvoice(Long id, InvoiceDTO invoiceDTO);
    InvoiceDTO getInvoiceById(Long id);
    void deleteInvoice(Long id);
    List<InvoiceDTO> getAllInvoices();
}
