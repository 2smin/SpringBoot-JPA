package org.zerock.ex02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.ex02.entity.mMember;

public interface mMemberRespository extends JpaRepository<mMember, Long> {
}
