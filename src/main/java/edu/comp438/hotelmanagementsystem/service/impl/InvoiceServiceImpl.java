package edu.comp438.hotelmanagementsystem.service.impl;

import edu.comp438.hotelmanagementsystem.dto.InvoiceDTO;
import edu.comp438.hotelmanagementsystem.entity.Invoice;
import edu.comp438.hotelmanagementsystem.mapper.InvoiceMapper;
import edu.comp438.hotelmanagementsystem.repository.InvoiceRepository;
import edu.comp438.hotelmanagementsystem.service.InvoiceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final InvoiceMapper invoiceMapper;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository, InvoiceMapper invoiceMapper) {
        this.invoiceRepository = invoiceRepository;
        this.invoiceMapper = invoiceMapper;
    }

    @Override
    public InvoiceDTO createInvoice(InvoiceDTO invoiceDTO) {
        Invoice invoice = invoiceMapper.toEntity(invoiceDTO);
        Invoice savedInvoice = invoiceRepository.save(invoice);
        return invoiceMapper.toDto(savedInvoice);
    }

    @Override
    public InvoiceDTO updateInvoice(Long id, InvoiceDTO invoiceDTO) {
        Invoice existingInvoice = invoiceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Invoice not found"));

        existingInvoice.setBooking(invoiceMapper.toEntity(invoiceDTO).getBooking());
        existingInvoice.setAmount(invoiceDTO.getAmount());
        existingInvoice.setInvoiceDate(invoiceDTO.getInvoiceDate());
        existingInvoice.setPaid(invoiceDTO.getPaid());

        Invoice updatedInvoice = invoiceRepository.save(existingInvoice);
        return invoiceMapper.toDto(updatedInvoice);
    }

    @Override
    public InvoiceDTO getInvoiceById(Long id) {
        Invoice invoice = invoiceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Invoice not found"));
        return invoiceMapper.toDto(invoice);
    }

    @Override
    public void deleteInvoice(Long id) {
        invoiceRepository.deleteById(id);
    }

    @Override
    public List<InvoiceDTO> getAllInvoices() {
        return invoiceRepository.findAll().stream()
                .map(invoiceMapper::toDto)
                .collect(Collectors.toList());
    }
}
