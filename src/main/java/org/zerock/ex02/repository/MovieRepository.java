package org.zerock.ex02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.ex02.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
