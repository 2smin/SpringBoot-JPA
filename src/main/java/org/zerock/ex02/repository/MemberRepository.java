package org.zerock.ex02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.ex02.entity.Member;

public interface MemberRepository extends JpaRepository<Member, String> {
}
