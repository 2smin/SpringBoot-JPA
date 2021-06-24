package org.zerock.ex02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.ex02.entity.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
}
