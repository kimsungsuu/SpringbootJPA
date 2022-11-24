package com.study.board.controller;

import com.study.board.entity.SpringBoard;
import com.study.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
    @GetMapping("/boardWrite")
    public String boardWrite(){
        return "boardWrite";
    }

    @PostMapping("/boardWritePro")
    public String boardWritePro(SpringBoard springBoard){

        boardService.boardWrite(springBoard);

        return "redirect:/boardList";
    }

    @GetMapping("/boardList")
    public String boardList(Model model){

        model.addAttribute("list", boardService.boardList());

        return "boardList";
    }

    @GetMapping("/boardView")
    public String boardView( Integer id, Model model){

        model.addAttribute("board", boardService.boardView(id));

        return "boardView";
    }

    @GetMapping("/boardDelete")
    public String boardDelete(Integer id){

        boardService.boardDelete(id);

        return "redirect:/boardList";
    }

    @GetMapping("/boardModify/{id}")
    public String boardModify(@PathVariable("id") Integer id, Model model){

        model.addAttribute("board", boardService.boardView(id));

        return "boardModify";
    }

    @PostMapping("/boardUpdate/{id}")
    public String boardUpdate(@PathVariable("id") Integer id, SpringBoard springBoard){

        SpringBoard springboardTemp = boardService.boardView(id);

        springboardTemp.setTitle(springBoard.getTitle());
        springboardTemp.setContent(springBoard.getContent());

        boardService.boardWrite(springboardTemp);

        return "redirect:/boardList";
    }
}
