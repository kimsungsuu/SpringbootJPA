package com.study.board.controller;

import com.study.board.entity.SpringBoard;
import com.study.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/boardWrite")
    public String boardWrite(){
        return "boardWrite";
    }

    @PostMapping("/boardWritePro")
    public String boardWritePro(SpringBoard springBoard, Model model, Integer id, MultipartFile file) throws Exception {

        boardService.boardWriter(springBoard, file);

        model.addAttribute("message", "글 작성이 완료되었습니다.");
        model.addAttribute("searchUrl", "/boardList");

        return "message";
    }

    @GetMapping("/boardList")
    public String boardList(Model model , @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable){

        Page<SpringBoard> list = boardService.boardList(pageable);

        int nowPage = list.getPageable().getPageNumber() + 1;
        int startPage = Math.max(nowPage-4, 1);
        int endPage = Math.min(nowPage+5, list.getTotalPages());

        model.addAttribute("list", list);
        model.addAttribute("nowPage", nowPage);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);

        return "boardList";
    }

    @GetMapping("/boardView")
    public String boardView(Integer id, Model model){
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
    
    @PostMapping("/boardUpdate")
    public String boardUpdate(Integer id, SpringBoard springBoard, Model model, MultipartFile file) throws Exception{
        SpringBoard springBoardTemp = boardService.boardView(id);
        springBoardTemp.setTitle(springBoard.getTitle());
        springBoardTemp.setContent(springBoard.getContent());

        model.addAttribute("message", "수정이 완료되었습니다.");
        model.addAttribute("searchUrl", "/boardList");

        boardService.boardWriter(springBoardTemp, file);
        
        return "message";
    }
}
