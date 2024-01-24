package com.stduy.membermange.service;

import com.stduy.membermange.entity.springboard;
import com.stduy.membermange.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public void boardWrtie(springboard springboard){
        boardRepository.save(springboard);
    }

    public List<springboard> boardList(){
        return boardRepository.findAll();
    }

    public springboard boardView(Integer id){
        return boardRepository.findById(id).get();
    }

    public void boardDelete(Integer id){
        boardRepository.deleteById(id);
    }
}
