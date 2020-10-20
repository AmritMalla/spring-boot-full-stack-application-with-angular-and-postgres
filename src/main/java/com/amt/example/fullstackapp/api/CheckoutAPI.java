package com.amt.example.fullstackapp.api;

import com.amt.example.fullstackapp.model.CheckoutDTO;
import com.amt.example.fullstackapp.model.request.CheckoutRequestDTO;
import com.amt.example.fullstackapp.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static com.amt.example.fullstackapp.constants.URLConstants.*;

@RestController
@RequestMapping(API_URL + CHECKOUTS_URL)
public class CheckoutAPI {

    private CheckoutService checkoutService;

    @Autowired
    public CheckoutAPI(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @GetMapping(ID_VARIABLE)
    public ResponseEntity<CheckoutDTO> getCheckoutById(@PathVariable("id")Long id) {
        Optional<CheckoutDTO> optional = checkoutService.getById(id);
        return optional.map(checkoutDTO -> new ResponseEntity<>(checkoutDTO, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity("Id : " + id + " not found", HttpStatus.BAD_REQUEST));
    }

    @PostMapping
    public ResponseEntity<String> createCheckout(@RequestBody CheckoutRequestDTO checkoutRequestDTO){
        if(checkoutService.save(checkoutRequestDTO) == 1){
            return ResponseEntity.ok("Successfully registered");
        }
        return ResponseEntity.badRequest().body("Failed to register");
    }

    @PutMapping
    public ResponseEntity<String> updateCheckout(@RequestBody CheckoutDTO checkoutDTO){
        if(checkoutService.update(checkoutDTO) == 1){
            return ResponseEntity.ok("Successfully updated");
        }
        return ResponseEntity.badRequest().body("Failed to update");
    }

    @DeleteMapping(ID_VARIABLE)
    public ResponseEntity<String> deleteCheckout(@PathVariable("id")Long id){
        if(checkoutService.delete(id) == 1){
            return ResponseEntity.ok("Successfully Deleted");
        }
        return ResponseEntity.badRequest().body("Failed to delete");
    }


}
