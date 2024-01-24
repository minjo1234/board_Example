package com.stduy.membermange.controller;

import com.stduy.membermange.entity.springboard;
import com.stduy.membermange.service.BoardService;
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

    // 게시글 작성폼 페이지
    @GetMapping("/") // localhost:8080/board/write
    public String boardWriteForm() {

        return "boardwrite";
    }
    @PostMapping("/board/writepro")
    public String boardWritePro(springboard springboard, Model model){
        // model.addAttribute("list", boardService.boardList())
        boardService.boardWrtie(springboard);
        return "redirect:/board/list";
    }

    @GetMapping("/board/list")
    public String boardList(Model model){
        model.addAttribute("list", boardService.boardList());
        return "boardlist";
    }

    @GetMapping("/board/view")
    public String boardView(Model model , Integer id){
        model.addAttribute("board", boardService.boardView(id));
        return "boardview";
    }

    @GetMapping("/board/delete")
    public String boardDelete(Integer id){
        boardService.boardDelete(id);
        return "redirect:/board/list";
    }

    @GetMapping("/board/modify/{id}")
    public String boardModify(Model model , @PathVariable("id") Integer id){
        model.addAttribute("board", boardService.boardView(id));
        return "boardmodify";
    }

    @PostMapping("/board/update/{id}")
    public String boardUpdate(Model model , @PathVariable("id") Integer id , springboard springboard){
        springboard boardTemp = boardService.boardView(id);
        boardTemp.setName(springboard.getName());
        boardTemp.setContent(springboard.getContent());

        boardService.boardWrtie(boardTemp);
        return "redirect:/board/list";
    }

}
