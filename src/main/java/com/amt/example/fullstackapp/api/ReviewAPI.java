package com.amt.example.fullstackapp.api;

import com.amt.example.fullstackapp.model.ReviewDTO;
import com.amt.example.fullstackapp.model.request.ReviewRequestDTO;
import com.amt.example.fullstackapp.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static com.amt.example.fullstackapp.constants.URLConstants.*;

@RestController
@RequestMapping(API_URL + REVIEWS_URL)
public class ReviewAPI {

    private ReviewService reviewService;

    @Autowired
    public ReviewAPI(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping(ID_VARIABLE)
    public ResponseEntity<ReviewDTO> getReviewById(@PathVariable("id")Long id) {
        Optional<ReviewDTO> optional = reviewService.getById(id);
        return optional.map(reviewDTO -> new ResponseEntity<>(reviewDTO, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity("Id : " + id + " not found", HttpStatus.BAD_REQUEST));
    }

    @PostMapping
    public ResponseEntity<String> createReview(@RequestBody ReviewRequestDTO reviewRequestDTO){
        if(reviewService.save(reviewRequestDTO) == 1){
            return ResponseEntity.ok("Successfully registered");
        }
        return ResponseEntity.badRequest().body("Failed to register");
    }

    @PutMapping
    public ResponseEntity<String> updateReview(@RequestBody ReviewDTO reviewDTO){
        if(reviewService.update(reviewDTO) == 1){
            return ResponseEntity.ok("Successfully updated");
        }
        return ResponseEntity.badRequest().body("Failed to update");
    }

    @DeleteMapping(ID_VARIABLE)
    public ResponseEntity<String> deleteReview(@PathVariable("id")Long id){
        if(reviewService.delete(id) == 1){
            return ResponseEntity.ok("Successfully Deleted");
        }
        return ResponseEntity.badRequest().body("Failed to delete");
    }


}
