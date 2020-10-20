package com.amt.example.fullstackapp.api;

import com.amt.example.fullstackapp.model.BookDTO;
import com.amt.example.fullstackapp.model.request.BookRequestDTO;
import com.amt.example.fullstackapp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static com.amt.example.fullstackapp.constants.URLConstants.*;

@RestController
@RequestMapping(API_URL + BOOKS_URL)
public class BookAPI {

    private BookService bookService;

    @Autowired
    public BookAPI(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(ID_VARIABLE)
    public ResponseEntity<BookDTO> getBookById(@PathVariable("id")Long id) {
        Optional<BookDTO> optional = bookService.getById(id);
        return optional.map(bookDTO -> new ResponseEntity<>(bookDTO, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity("Id : " + id + " not found", HttpStatus.BAD_REQUEST));
    }

    @PostMapping
    public ResponseEntity<String> createBook(@RequestBody BookRequestDTO bookRequestDTO){
        if(bookService.save(bookRequestDTO) == 1){
            return ResponseEntity.ok("Successfully registered");
        }
        return ResponseEntity.badRequest().body("Failed to register");
    }

    @PutMapping
    public ResponseEntity<String> updateBook(@RequestBody BookDTO dto){
        if(bookService.update(dto) == 1){
            return ResponseEntity.ok("Successfully updated");
        }
        return ResponseEntity.badRequest().body("Failed to update");
    }

    @DeleteMapping(ID_VARIABLE)
    public ResponseEntity<String> deleteBook(@PathVariable("id")Long id){
        if(bookService.delete(id) == 1){
            return ResponseEntity.ok("Successfully Deleted");
        }
        return ResponseEntity.badRequest().body("Failed to delete");
    }


}
