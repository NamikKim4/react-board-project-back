package com.example.ch8_5.servieImpl;

import com.example.ch8_5.mapper.BoardMapper;
import com.example.ch8_5.service.BoardService;
import com.example.ch8_5.to.BoardTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;

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
        return boardMapper.selectBoardByBno(bno);
    }

    @Override
    public void registerBoard(BoardTo boardTo) {
        boardMapper.insertBoard(boardTo);
    }

    @Override
    public void modifyBoard(BoardTo boardTo) {
        System.out.println("BoardTo⭐=" + boardTo);
        boardMapper.updateBoard(boardTo);
    }

    @Override
    public void concealBoard(Map<String, Object> map) {
        boardMapper.hideBoard(map);
    }

    @Override
    public void deleteBoard(Map<String, Object> map) {
        boardMapper.deleteBoard(map);
    }

    @Override
    public void removeBoard(BoardTo boardTo) {

    }
}
