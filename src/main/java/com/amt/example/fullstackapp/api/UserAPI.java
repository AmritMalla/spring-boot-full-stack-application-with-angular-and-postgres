package com.amt.example.fullstackapp.api;

import com.amt.example.fullstackapp.model.UserDTO;
import com.amt.example.fullstackapp.model.request.UserRequestDTO;
import com.amt.example.fullstackapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<UserDTO> getUserById(@PathVariable("id")Long id) {
        Optional<UserDTO> optional = userService.getById(id);
        return optional.map(userDTO -> new ResponseEntity<>(userDTO, HttpStatus.OK)).orElseGet(() -> new ResponseEntity("Id : " + id + " not found", HttpStatus.BAD_REQUEST));
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UserRequestDTO userRequestDTO){
        if(userService.save(userRequestDTO) == 1){
            return ResponseEntity.ok("Successfully registered");
        }
        return ResponseEntity.badRequest().body("Failed to register");
    }

    @PutMapping
    public ResponseEntity<String> updateUser(@RequestBody UserDTO userDTO){
        if(userService.update(userDTO) == 1){
            return ResponseEntity.ok("Successfully updated");
        }
        return ResponseEntity.badRequest().body("Failed to update");
    }

    @DeleteMapping(ID_VARIABLE)
    public ResponseEntity<String> deleteUser(@PathVariable("id")Long id){
        if(userService.delete(id) == 1){
            return ResponseEntity.ok("Successfully Deleted");
        }
        return ResponseEntity.badRequest().body("Failed to delete");
    }


}
