package org.zerock.ex02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.ex02.entity.MovieImage;

public interface MovieImageRepository extends JpaRepository<MovieImage, Long> {

}
