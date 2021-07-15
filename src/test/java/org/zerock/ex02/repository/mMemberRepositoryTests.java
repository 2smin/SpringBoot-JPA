package org.zerock.ex02.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import org.springframework.test.annotation.Commit;
import org.zerock.ex02.entity.mMember;
import org.zerock.ex02.entity.mMember;

import javax.transaction.Transactional;
import java.util.stream.IntStream;

@SpringBootTest
public class mMemberRepositoryTests {

    @Autowired
    private mMemberRespository mmemberRespository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    public void insertMMember(){

        IntStream.rangeClosed(1,100).forEach(i -> {

            mMember mmember = mMember.builder().email("r" + i + "@zerock.org")
                    .pw("1111")
                    .nickname("revier" + i)
                    .build();

            mmemberRespository.save(mmember);
        });
    }

    @Commit
    @Transactional
    @Test
    public void testDeleteMovieMember(){

        Long mid = 3L;

        mMember mmember = mMember.builder().mid(mid).build();

        reviewRepository.deleteBymMember(mmember);
        mmemberRespository.deleteById(mid);


    }
}
