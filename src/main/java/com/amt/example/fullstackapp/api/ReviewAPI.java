package com.amt.example.fullstackapp.api;

import com.amt.example.fullstackapp.exception.InvalidUserIdException;
import com.amt.example.fullstackapp.exception.ResourceNotFoundException;
import com.amt.example.fullstackapp.model.BookDTO;
import com.amt.example.fullstackapp.model.ReviewDTO;
import com.amt.example.fullstackapp.model.request.ReviewRequestDTO;
import com.amt.example.fullstackapp.responseMessage.ApiResponseMessage;
import com.amt.example.fullstackapp.service.BookService;
import com.amt.example.fullstackapp.service.ReviewService;
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
@RequestMapping(API_URL + REVIEWS_URL)
public class ReviewAPI {

    private ReviewService reviewService;

    private BookService bookService;

    private UserService userService;

    @Autowired
    public ReviewAPI(ReviewService reviewService, BookService bookService, UserService userService) {
        this.reviewService = reviewService;
        this.bookService = bookService;
        this.userService = userService;
    }

    @GetMapping(ID_VARIABLE)
    public ResponseEntity<ReviewDTO> getReviewById(@PathVariable("id") Long id) {
        Optional<ReviewDTO> optional = reviewService.getById(id);
        if (!optional.isPresent()) {
            throw new ResourceNotFoundException("Id : " + id + " not found");
        }
        return new ResponseEntity<>(optional.get(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ReviewDTO>> getAllBooks() {
        return new ResponseEntity<>(reviewService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiResponseMessage> createReview(@Valid @RequestBody ReviewRequestDTO dto) {
        if (!bookService.existById(dto.getBookId())) {
            throw new ResourceNotFoundException("The book id : " + dto.getBookId() + " doesn't exist");
        }

        if (!userService.existByUsername(dto.getReviewerName())){
            throw new ResourceNotFoundException("The username  " + dto.getReviewerName() + " doesn't exist");
        }
        ApiResponseMessage message = new ApiResponseMessage();
        reviewService.save(dto);
        message.setMessage("Review successfully saved");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ApiResponseMessage> updateReview(@Valid @RequestBody ReviewRequestDTO dto) {
        if (!bookService.existById(dto.getBookId())) {
            throw new ResourceNotFoundException("The book id : " + dto.getBookId() + " doesn't exist");
        }

        if (!userService.existByUsername(dto.getReviewerName())){
            throw new ResourceNotFoundException("The username  " + dto.getReviewerName() + " doesn't exist");
        }

        if(reviewService.existById(dto.getId())){
            throw new ResourceNotFoundException("The username  " + dto.getReviewerName() + " doesn't exist");
        }
        ApiResponseMessage message = new ApiResponseMessage();
        reviewService.update(dto);
        message.setMessage("Review successfully updated");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping(ID_VARIABLE)
    public ResponseEntity<ApiResponseMessage> deleteReview(@PathVariable("id") Long id) {
        if(!reviewService.existById(id)){
            throw new ResourceNotFoundException("The userId : " + id + " not found.");
        }
        reviewService.delete(id);
        ApiResponseMessage responseMessage = new ApiResponseMessage();
        responseMessage.setMessage("Review successfully deleted");
        return new ResponseEntity<>(responseMessage,HttpStatus.OK);
    }


}
