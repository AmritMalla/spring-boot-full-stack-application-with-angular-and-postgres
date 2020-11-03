package com.amt.example.fullstackapp.api;

import com.amt.example.fullstackapp.exception.ResourceNotFoundException;
import com.amt.example.fullstackapp.model.BookDTO;
import com.amt.example.fullstackapp.model.UserDTO;
import com.amt.example.fullstackapp.model.request.UserRequestDTO;
import com.amt.example.fullstackapp.responseMessage.ApiResponseMessage;
import com.amt.example.fullstackapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static com.amt.example.fullstackapp.constants.URLConstants.*;

@RestController
@RequestMapping(API_URL + USERS_URL)
public class UserAPI {

    private UserService userService;

    @Autowired
    public UserAPI(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(ID_VARIABLE)
    public ResponseEntity<UserDTO> getUserById(@PathVariable("id") Long id) {
        Optional<UserDTO> optional = userService.getById(id);
        if (!optional.isPresent()) {
            throw new ResourceNotFoundException("Id : " + id + " not found");
        }
        return new ResponseEntity<>(optional.get(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllBooks() {
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiResponseMessage> createUser(@RequestBody UserRequestDTO dto) {
        ApiResponseMessage responseMessage = new ApiResponseMessage();
        userService.save(dto);
        responseMessage.setMessage("User successfully registered");
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ApiResponseMessage> updateUser(@Valid @RequestBody UserRequestDTO dto) {
        if (userService.existById(dto.getId())) {
            throw new ResourceNotFoundException("User with id " + dto.getId() + " not found");
        }
        ApiResponseMessage responseMessage = new ApiResponseMessage();
        userService.update(dto);
        responseMessage.setMessage("User successfully registered");
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);

    }

    @DeleteMapping(ID_VARIABLE)
    public ResponseEntity<ApiResponseMessage> deleteUser(@PathVariable("id") Long id) {
        if (!userService.existById(id)) {
            throw new ResourceNotFoundException("User with id : " + id + " doesn't exist");
        }
        userService.delete(id);
        ApiResponseMessage responseMessage = new ApiResponseMessage();
        responseMessage.setMessage("Address successfully deleted");
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }


}
