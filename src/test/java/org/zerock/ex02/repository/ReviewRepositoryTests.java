package org.zerock.ex02.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.ex02.entity.mMember;
import org.zerock.ex02.entity.Movie;
import org.zerock.ex02.entity.Review;

import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
public class ReviewRepositoryTests {

    @Autowired
    private ReviewRepository repository;

    @Test
    public void insertMovieReviews(){

        IntStream.rangeClosed(1,200).forEach(i -> {

            Long mno = (long)(Math.random() * 100) +1;
            Long mid = ((long)(Math.random()*100) + 1);

            mMember mmember = mMember.builder().mid(mid).build();

            Review movieReview = Review.builder()
                    .mMember(mmember)
                    .movie(Movie.builder().mno(mno).build())
                    .grade((int)(Math.random()*5)+1)
                    .text("reivew of Movie..." + i)
                    .build();

            repository.save(movieReview);
        });
    }

    @Test
    public void testGetMovieWithReviews(){

        Movie movie = Movie.builder().mno(93L)
                .build();

        List<Review> result = repository.findByMovie(movie);

        result.forEach(movieReview -> {
            System.out.println(movieReview.getReviewnum());
            System.out.println(movieReview.getGrade());
            System.out.println(movieReview.getText());
            System.out.println(movieReview.getMMember().getEmail());
        });
    }

}
