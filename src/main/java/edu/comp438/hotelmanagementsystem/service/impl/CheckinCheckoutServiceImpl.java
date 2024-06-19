package edu.comp438.hotelmanagementsystem.service.impl;

import edu.comp438.hotelmanagementsystem.dto.CheckinCheckoutDTO;
import edu.comp438.hotelmanagementsystem.entity.CheckinCheckout;
import edu.comp438.hotelmanagementsystem.mapper.CheckinCheckoutMapper;
import edu.comp438.hotelmanagementsystem.repository.CheckinCheckoutRepository;
import edu.comp438.hotelmanagementsystem.service.CheckinCheckoutService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CheckinCheckoutServiceImpl implements CheckinCheckoutService {

    private final CheckinCheckoutRepository checkinCheckoutRepository;

    private final CheckinCheckoutMapper checkinCheckoutMapper;

    public CheckinCheckoutServiceImpl(CheckinCheckoutRepository checkinCheckoutRepository, CheckinCheckoutMapper checkinCheckoutMapper) {
        this.checkinCheckoutRepository = checkinCheckoutRepository;
        this.checkinCheckoutMapper = checkinCheckoutMapper;
    }

    @Override
    public CheckinCheckoutDTO createCheckinCheckout(CheckinCheckoutDTO checkinCheckoutDTO) {
        CheckinCheckout checkinCheckout = checkinCheckoutMapper.toEntity(checkinCheckoutDTO);
        CheckinCheckout savedCheckinCheckout = checkinCheckoutRepository.save(checkinCheckout);
        return checkinCheckoutMapper.toDto(savedCheckinCheckout);
    }

    @Override
    public CheckinCheckoutDTO updateCheckinCheckout(Long id, CheckinCheckoutDTO checkinCheckoutDTO) {
        CheckinCheckout existingCheckinCheckout = checkinCheckoutRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("CheckinCheckout not found"));

        // Update existingCheckinCheckout properties with checkinCheckoutDTO data
        existingCheckinCheckout.setBooking(checkinCheckoutMapper.toEntity(checkinCheckoutDTO).getBooking());
        existingCheckinCheckout.setCheckinDate(checkinCheckoutDTO.getCheckinDate());
        existingCheckinCheckout.setCheckoutDate(checkinCheckoutDTO.getCheckoutDate());
        existingCheckinCheckout.setCheckedIn(checkinCheckoutDTO.getCheckedIn());
        existingCheckinCheckout.setCheckedOut(checkinCheckoutDTO.getCheckedOut());

        CheckinCheckout updatedCheckinCheckout = checkinCheckoutRepository.save(existingCheckinCheckout);
        return checkinCheckoutMapper.toDto(updatedCheckinCheckout);
    }

    @Override
    public CheckinCheckoutDTO getCheckinCheckoutById(Long id) {
        CheckinCheckout checkinCheckout = checkinCheckoutRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("CheckinCheckout not found"));
        return checkinCheckoutMapper.toDto(checkinCheckout);
    }

    @Override
    public void deleteCheckinCheckout(Long id) {
        checkinCheckoutRepository.deleteById(id);
    }

    @Override
    public List<CheckinCheckoutDTO> getAllCheckinCheckouts() {
        return checkinCheckoutRepository.findAll().stream()
                .map(checkinCheckoutMapper::toDto)
                .collect(Collectors.toList());
    }
}
