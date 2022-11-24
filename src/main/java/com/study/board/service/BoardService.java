package com.study.board.service;

import com.study.board.entity.SpringBoard;
import com.study.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public void boardWrite(SpringBoard springBoard){
        boardRepository.save(springBoard);
    }

    public List<SpringBoard> boardList(){
        List<SpringBoard> boardList = boardRepository.findAll();

        return boardList;
    }

    public SpringBoard boardView(Integer id){
         return boardRepository.findById(id).get();
    }

    public void boardDelete(Integer id){
        boardRepository.deleteById(id);
    }

}
