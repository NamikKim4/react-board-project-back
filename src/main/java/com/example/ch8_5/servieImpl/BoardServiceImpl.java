package com.example.ch8_5.servieImpl;

import com.example.ch8_5.mapper.BoardMapper;
import com.example.ch8_5.service.BoardService;
import com.example.ch8_5.to.BoardTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardMapper boardMapper;

    @Override
    public ArrayList<BoardTo> findBoardAll() {
        return boardMapper.selectBoardAll();
    }

    @Override
    public BoardTo findBoardByBno(int bno) {
        return null;
    }

    @Override
    public void registerBoard(BoardTo boardTo) {
        boardMapper.insertBoard(boardTo);
    }

    @Override
    public void modifyBoard(BoardTo boardTo) {

    }

    @Override
    public void concealBoard(BoardTo boardTo) {

    }

    @Override
    public void removeBoard(BoardTo boardTo) {

    }
}
