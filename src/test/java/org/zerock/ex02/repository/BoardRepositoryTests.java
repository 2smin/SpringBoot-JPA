package org.zerock.ex02.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.zerock.ex02.entity.Board;
import org.zerock.ex02.entity.Member;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class BoardRepositoryTests {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void insertBoard(){

        IntStream.rangeClosed(1,100).forEach(i -> {

            Member member = Member.builder().email("user" + i + "@aaa.com").build();

            Board board = Board.builder()
                    .title("Title...." + i)
                    .content("Content...." + i)
                    .writer(member)
                    .build();

            boardRepository.save(board);

        });
    }

    @Transactional
    @Test
    public void testRead1(){

        Optional<Board> result = boardRepository.findById(204L);

        Board board = result.get();

        System.out.println(board);
        System.out.println(board.getWriter());
    }

    @Test
    public void testReadWithWriter(){

        Object result = boardRepository.getBoardWithWriter(204L);

        Object[] arr = (Object[]) result;


        System.out.println("------------------------");
        System.out.println(Arrays.toString(arr));
    }
    
    @Test
    public void testGetBoardWithReply(){
        
        List<Object[]> result = boardRepository.getBoardWithReply(204L);

        for (Object[] objects : result) {
            System.out.println(Arrays.toString(objects));
        }
    }

    @Test
    public void testWithReplyCount(){

        Pageable pageable = PageRequest.of(0,10, Sort.by("bno").descending());
        Page<Object[]> result = boardRepository.getBoardWithReplyCount(pageable);

        result.get().forEach(row -> {

            Object[] arr = (Object[]) row;

            System.out.println(Arrays.toString(arr));
        });
    }
}
