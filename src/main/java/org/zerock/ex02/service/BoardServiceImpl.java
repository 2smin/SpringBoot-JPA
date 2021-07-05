package org.zerock.ex02.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.zerock.ex02.dto.BoardDTO;
import org.zerock.ex02.dto.PageRequestDTO;
import org.zerock.ex02.dto.PageResultDTO;
import org.zerock.ex02.entity.Board;
import org.zerock.ex02.entity.Member;
import org.zerock.ex02.repository.BoardRepository;
import org.zerock.ex02.repository.ReplyRepository;

import javax.transaction.Transactional;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
@Log4j2
public class BoardServiceImpl implements BoardService{

    private final BoardRepository BoardRepository;

    private final ReplyRepository replyRepository;

    @Override
    public Long register(BoardDTO dto){

        log.info(dto);

        Board board = dtoToEntity(dto);

        BoardRepository.save(board);

        return board.getBno();
    }

    @Override
    public PageResultDTO<BoardDTO, Object[]> getList(PageRequestDTO pageRequestDTO){

        log.info(pageRequestDTO);

        Function<Object[], BoardDTO> fn = (en -> entityToDTO((Board)en[0],(Member)en[1],(Long)en[2]));

        Page<Object[]> result = BoardRepository
                .getBoardWithReplyCount(pageRequestDTO.getPageable(Sort.by("bno").descending()));

        return new PageResultDTO<>(result, fn);
    }

    @Override
    public BoardDTO get(Long bno){

        Object result = BoardRepository.getBoardByBno(bno);

        Object[] arr = (Object[]) result;

        return entityToDTO((Board)arr[0],(Member)arr[1],(Long)arr[2]);
    }

    @Transactional
    @Override
    public void removeWithReplies(Long bno){

        replyRepository.deleteByBno(bno);
        BoardRepository.deleteById(bno);
    }

    @Transactional
    @Override
    public void modify(BoardDTO boardDTO){

        Board board = BoardRepository.getById(boardDTO.getBno());

        board.changeTitle(boardDTO.getTitle());
        board.changeContent(boardDTO.getContent());
        BoardRepository.save(board);


    }
}
