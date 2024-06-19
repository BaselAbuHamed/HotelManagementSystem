package edu.comp438.hotelmanagementsystem.service.impl;

import edu.comp438.hotelmanagementsystem.dto.PaymentStatusDTO;
import edu.comp438.hotelmanagementsystem.entity.PaymentStatus;
import edu.comp438.hotelmanagementsystem.mapper.PaymentStatusMapper;
import edu.comp438.hotelmanagementsystem.repository.PaymentStatusRepository;
import edu.comp438.hotelmanagementsystem.service.PaymentStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentStatusServiceImpl implements PaymentStatusService {

    private final PaymentStatusRepository paymentStatusRepository;

    private final PaymentStatusMapper paymentStatusMapper;

    public PaymentStatusServiceImpl(PaymentStatusRepository paymentStatusRepository, PaymentStatusMapper paymentStatusMapper) {
        this.paymentStatusRepository = paymentStatusRepository;
        this.paymentStatusMapper = paymentStatusMapper;
    }

    @Override
    public PaymentStatusDTO createPaymentStatus(PaymentStatusDTO paymentStatusDTO) {
        PaymentStatus paymentStatus = paymentStatusMapper.toEntity(paymentStatusDTO);
        PaymentStatus savedPaymentStatus = paymentStatusRepository.save(paymentStatus);
        return paymentStatusMapper.toDto(savedPaymentStatus);
    }

    @Override
    public PaymentStatusDTO updatePaymentStatus(Long id, PaymentStatusDTO paymentStatusDTO) {
        PaymentStatus existingPaymentStatus = paymentStatusRepository.findById(id).orElseThrow(() -> new RuntimeException("PaymentStatus not found"));
        existingPaymentStatus.setPaymentStatusName(paymentStatusDTO.getPaymentStatusName());
        PaymentStatus updatedPaymentStatus = paymentStatusRepository.save(existingPaymentStatus);
        return paymentStatusMapper.toDto(updatedPaymentStatus);
    }

    @Override
    public PaymentStatusDTO getPaymentStatusById(Long id) {
        PaymentStatus paymentStatus = paymentStatusRepository.findById(id).orElseThrow(() -> new RuntimeException("PaymentStatus not found"));
        return paymentStatusMapper.toDto(paymentStatus);
    }

    @Override
    public void deletePaymentStatus(Long id) {
        paymentStatusRepository.deleteById(id);
    }

    @Override
    public List<PaymentStatusDTO> getAllPaymentStatuses() {
        return paymentStatusRepository.findAll().stream()
                .map(paymentStatusMapper::toDto)
                .collect(Collectors.toList());
    }
}
