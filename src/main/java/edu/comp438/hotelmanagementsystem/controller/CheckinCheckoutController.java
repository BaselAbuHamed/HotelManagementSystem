package edu.comp438.hotelmanagementsystem.controller;

import edu.comp438.hotelmanagementsystem.dto.CheckinCheckoutDTO;
import edu.comp438.hotelmanagementsystem.service.CheckinCheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/checkincheckouts")
public class CheckinCheckoutController {

    private final CheckinCheckoutService checkinCheckoutService;

    @Autowired
    public CheckinCheckoutController(CheckinCheckoutService checkinCheckoutService) {
        this.checkinCheckoutService = checkinCheckoutService;
    }

    @PostMapping
    public ResponseEntity<CheckinCheckoutDTO> createCheckinCheckout(@RequestBody CheckinCheckoutDTO checkinCheckoutDTO) {
        CheckinCheckoutDTO createdCheckinCheckout = checkinCheckoutService.createCheckinCheckout(checkinCheckoutDTO);
        return ResponseEntity.ok(createdCheckinCheckout);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CheckinCheckoutDTO> updateCheckinCheckout(@PathVariable Long id, @RequestBody CheckinCheckoutDTO checkinCheckoutDTO) {
        CheckinCheckoutDTO updatedCheckinCheckout = checkinCheckoutService.updateCheckinCheckout(id, checkinCheckoutDTO);
        return ResponseEntity.ok(updatedCheckinCheckout);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CheckinCheckoutDTO> getCheckinCheckoutById(@PathVariable Long id) {
        CheckinCheckoutDTO checkinCheckoutDTO = checkinCheckoutService.getCheckinCheckoutById(id);
        return ResponseEntity.ok(checkinCheckoutDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCheckinCheckout(@PathVariable Long id) {
        checkinCheckoutService.deleteCheckinCheckout(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<CheckinCheckoutDTO>> getAllCheckinCheckouts() {
        List<CheckinCheckoutDTO> checkinCheckouts = checkinCheckoutService.getAllCheckinCheckouts();
        return ResponseEntity.ok(checkinCheckouts);
    }
}
