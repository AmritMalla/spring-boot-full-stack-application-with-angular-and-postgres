package com.amt.example.fullstackapp.api;

import com.amt.example.fullstackapp.exception.InvalidUserIdException;
import com.amt.example.fullstackapp.exception.ResourceNotFoundException;
import com.amt.example.fullstackapp.exception.UserIdAlreadyExistException;
import com.amt.example.fullstackapp.model.AddressDTO;
import com.amt.example.fullstackapp.model.request.AddressRequestDTO;
import com.amt.example.fullstackapp.responseMessage.ApiResponseMessage;
import com.amt.example.fullstackapp.service.AddressService;
import com.amt.example.fullstackapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

import static com.amt.example.fullstackapp.constants.URLConstants.*;

@RestController
@RequestMapping(API_URL + ADDRESSES_URL)
public class AddressAPI {

    private AddressService addressService;

    private UserService userService;

    @Autowired
    public AddressAPI(AddressService addressService, UserService userService) {
        this.addressService = addressService;
        this.userService = userService;
    }

    @GetMapping(USER_ID_VARIABLE)
    public ResponseEntity<AddressDTO> getAddressById(@PathVariable("userId") Long userId) {
        Optional<AddressDTO> optional = addressService.getById(userId);
        if (!optional.isPresent()) {
            throw new ResourceNotFoundException("Address with id -- " + userId + " not found.");
        }
        return new ResponseEntity<>(optional.get(), HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<ApiResponseMessage> createAddress(@Valid @RequestBody AddressRequestDTO dto) {
        if (!userService.existById(dto.getUserId())) {
            throw new InvalidUserIdException("User with given id : " + dto.getUserId() + " doesn't exist");
        }

        if (addressService.existByUserId(dto.getUserId())) {
            throw new UserIdAlreadyExistException("User with given id : " + dto.getUserId() + " already exist");
        }

        ApiResponseMessage message = new ApiResponseMessage();
        addressService.save(dto);
        message.setMessage("Address successfully registered");
        return new ResponseEntity<>(message, HttpStatus.OK);

    }

    @PutMapping
    public ResponseEntity<ApiResponseMessage> updateAddress(@Valid @RequestBody AddressRequestDTO dto) {
        if (!userService.existById(dto.getUserId())) {
            throw new InvalidUserIdException("User with given id : " + dto.getUserId() + " doesn't exist");
        }

        ApiResponseMessage responseMessage = new ApiResponseMessage();
        addressService.update(dto);
        responseMessage.setMessage("Address successfully updated");
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

    @DeleteMapping(USER_ID_VARIABLE)
    public ResponseEntity<ApiResponseMessage> deleteAddress(@PathVariable("userId") Long userId) {
        if(!addressService.existByUserId(userId)){
            throw new InvalidUserIdException("The userId : " + userId + " not found.");
        }
        addressService.delete(userId);
        ApiResponseMessage responseMessage = new ApiResponseMessage();
        responseMessage.setMessage("Address successfully deleted");
        return new ResponseEntity<>(responseMessage,HttpStatus.OK);

    }


}
