package org.zerock.ex02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.ex02.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
