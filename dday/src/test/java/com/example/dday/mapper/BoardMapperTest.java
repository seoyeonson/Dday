package com.example.dday.mapper;

import com.example.dday.domain.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class BoardMapperTest {
    @Autowired
    private BoardMapper boardMapper;

    @Test
    public void insertTest(){
        BoardVO boardVO = new BoardVO();
        boardVO.create("새로 작성한 게시글 제목", "홍길동", "새로 작성한 게시글 내용");
        boardMapper.insert(boardVO);
        log.info("boardNumber: " + boardVO.getBoardNumber());
    }

    @Test
    public void updateTest(){
        BoardVO boardVO = boardMapper.select(1L);
        boardVO.setBoardTitle("수정된 게시글 제목");
        boardMapper.update(boardVO);
    }

    @Test
    public void selectTest(){
        log.info("board: " + boardMapper.select(1L));
    }

    @Test
    public void selectAllTest(){
        boardMapper.selectAll().stream().map(BoardVO::getBoardTitle).forEach(log::info);
    }
}


















