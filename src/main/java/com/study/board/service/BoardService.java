package com.study.board.service;

import com.study.board.entity.SpringBoard;
import com.study.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public void boardWriter(SpringBoard springBoard, MultipartFile file) throws Exception{

       String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\file\\";

       UUID uuid = UUID.randomUUID();

       String fileName = uuid + "_" + file.getOriginalFilename();

       File saveFile = new File(projectPath, fileName);

       file.transferTo(saveFile);

       springBoard.setFilename(fileName);
       springBoard.setFilepath("/file/" + fileName);

        boardRepository.save(springBoard);
    }

    public Page<SpringBoard> boardList(Pageable pageable){
        return boardRepository.findAll(pageable);
    }

    public SpringBoard boardView(Integer id){
        return boardRepository.findById(id).get();
    }

    public void boardDelete(Integer id){
        boardRepository.deleteById(id);
    }
}
