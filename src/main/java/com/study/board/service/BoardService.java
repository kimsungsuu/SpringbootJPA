package com.study.board.service;

import com.study.board.entity.SpringBoard;
import com.study.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    /**
     * 글 작성
     */
    public void boardWrite(SpringBoard springBoard){

        boardRepository.save(springBoard);
    }

    /**
     * 게시글 리스트
     */
    public List<SpringBoard> boardList(){
        return boardRepository.findAll();
    }

    /**
     * 게시글 상세 페이지
     */
    public SpringBoard boardView(Integer id){


        return boardRepository.findById(id).get();
    }

    /**
     * 게시글 삭제
     */
    public void deleteBoard(Integer id){
        boardRepository.deleteById(id);
    }
}
