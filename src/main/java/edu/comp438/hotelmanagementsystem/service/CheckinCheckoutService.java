package edu.comp438.hotelmanagementsystem.service;

import edu.comp438.hotelmanagementsystem.dto.CheckinCheckoutDTO;
import java.util.List;

public interface CheckinCheckoutService {
    CheckinCheckoutDTO createCheckinCheckout(CheckinCheckoutDTO checkinCheckoutDTO);
    CheckinCheckoutDTO updateCheckinCheckout(Long id, CheckinCheckoutDTO checkinCheckoutDTO);
    CheckinCheckoutDTO getCheckinCheckoutById(Long id);
    void deleteCheckinCheckout(Long id);
    List<CheckinCheckoutDTO> getAllCheckinCheckouts();
}
