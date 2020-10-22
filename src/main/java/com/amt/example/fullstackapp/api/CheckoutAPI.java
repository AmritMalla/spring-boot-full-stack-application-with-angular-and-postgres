package com.amt.example.fullstackapp.api;

import com.amt.example.fullstackapp.exception.InvalidUserIdException;
import com.amt.example.fullstackapp.exception.ResourceNotFoundException;
import com.amt.example.fullstackapp.model.CheckoutDTO;
import com.amt.example.fullstackapp.model.request.CheckoutRequestDTO;
import com.amt.example.fullstackapp.responseMessage.ApiResponseMessage;
import com.amt.example.fullstackapp.service.BookService;
import com.amt.example.fullstackapp.service.CheckoutService;
import com.amt.example.fullstackapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

import static com.amt.example.fullstackapp.constants.URLConstants.*;

@RestController
@RequestMapping(API_URL + CHECKOUTS_URL)
public class CheckoutAPI {

    private CheckoutService checkoutService;

    private BookService bookService;

    private UserService userService;

    @Autowired
    public CheckoutAPI(CheckoutService checkoutService, BookService bookService, UserService userService) {
        this.checkoutService = checkoutService;
        this.bookService = bookService;
        this.userService = userService;
    }

    @GetMapping(ID_VARIABLE)
    public ResponseEntity<CheckoutDTO> getCheckoutById(@PathVariable("id") Long id) {
        Optional<CheckoutDTO> optional = checkoutService.getById(id);
        if (!optional.isPresent()) {
            throw new ResourceNotFoundException("Id : " + id + " not found");
        }
        return new ResponseEntity<>(optional.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiResponseMessage> createCheckout(@Valid @RequestBody CheckoutRequestDTO dto) {
        if (!bookService.existById(dto.getBookId())) {
            throw new ResourceNotFoundException("The specified book with id : " + dto.getBookId() + " is not present");
        }

        if (userService.existById(dto.getUserId())) {
            throw new ResourceNotFoundException("The specified user with id : " + dto.getBookId() + " is not present");
        }

        ApiResponseMessage responseMessage = new ApiResponseMessage();
        checkoutService.save(dto);
        responseMessage.setMessage("Successfully saved the checkout");
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ApiResponseMessage> updateCheckout(@Valid @RequestBody CheckoutRequestDTO dto) {
        if (!bookService.existById(dto.getBookId())) {
            throw new ResourceNotFoundException("The specified book with id : " + dto.getBookId() + " is not present");
        }

        if (userService.existById(dto.getUserId())) {
            throw new ResourceNotFoundException("The specified user with id : " + dto.getBookId() + " is not present");
        }

        if (checkoutService.existById(dto.getId())) {
            throw new ResourceNotFoundException("The checkout id -- " + dto.getId() + " is not present");
        }

        ApiResponseMessage responseMessage = new ApiResponseMessage();
        checkoutService.update(dto);
        responseMessage.setMessage("Successfully saved the checkout");
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

    @DeleteMapping(ID_VARIABLE)
    public ResponseEntity<ApiResponseMessage> deleteCheckout(@PathVariable("id") Long id) {
        if (!checkoutService.existById(id)) {
            throw new InvalidUserIdException("The checkout id  : " + id + " not found.");
        }
        checkoutService.delete(id);
        ApiResponseMessage responseMessage = new ApiResponseMessage();
        responseMessage.setMessage("Address successfully deleted");
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

}
