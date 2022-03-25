package com.netcracker.edu.review.Service;

import com.netcracker.edu.review.SpringBootTest;
import com.netcracker.edu.review.service.ReviewService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ReviewServiceTest extends SpringBootTest {
    @Autowired
    ReviewService reviewService;

    @Test
    public void getReviewTest() {
        Object result = reviewService.findReviewByPlaceId(80);
        Assertions.assertNotEquals(null, result);
    }
}
