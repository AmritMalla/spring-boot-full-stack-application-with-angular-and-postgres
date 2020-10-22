package com.amt.example.fullstackapp.api;

import com.amt.example.fullstackapp.exception.ResourceNotFoundException;
import com.amt.example.fullstackapp.model.BookDTO;
import com.amt.example.fullstackapp.model.request.BookRequestDTO;
import com.amt.example.fullstackapp.responseMessage.ApiResponseMessage;
import com.amt.example.fullstackapp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
        if(!optional.isPresent()){
            throw new ResourceNotFoundException("Id : " + id + " not found");
        }
        return new ResponseEntity<>(optional.get(),HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<ApiResponseMessage> createBook(@Valid @RequestBody BookRequestDTO dto){
        ApiResponseMessage responseMessage = new ApiResponseMessage();
        bookService.save(dto);
        responseMessage.setMessage("Successfully saved the book");
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ApiResponseMessage> updateBook(@Valid @RequestBody BookRequestDTO dto){
        if(!bookService.existById(dto.getId())){
            throw new ResourceNotFoundException("The book id " + dto.getId() + " doesn't exist");
        }
        ApiResponseMessage responseMessage = new ApiResponseMessage();
        bookService.update(dto);
        responseMessage.setMessage("Successfully updated the book");
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

    @DeleteMapping(ID_VARIABLE)
    public ResponseEntity<ApiResponseMessage> deleteBook(@PathVariable("id")Long id){
        if(!bookService.existById(id)){
            throw new ResourceNotFoundException("Books with id : " + id + " doesn't exist");
        }
        bookService.delete(id);
        ApiResponseMessage responseMessage = new ApiResponseMessage();
        responseMessage.setMessage("Address successfully deleted");
        return new ResponseEntity<>(responseMessage,HttpStatus.OK);
    }


}
