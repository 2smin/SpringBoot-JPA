package org.zerock.ex02.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.ex02.entity.mMember;

import java.util.stream.IntStream;

@SpringBootTest
public class mMemberRepositoryTests {

    @Autowired
    mMemberRespository mMemberRespository;

    @Test
    public void insertMMember(){

        IntStream.rangeClosed(1,100).forEach(i -> {

            mMember member = mMember.builder().email("r" + i + "@zerock.org")
                    .pw("1111")
                    .nickname("revier" + i)
                    .build();

            mMemberRespository.save(member);
        });
    }
}
