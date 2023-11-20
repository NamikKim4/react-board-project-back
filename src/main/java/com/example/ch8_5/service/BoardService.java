package com.example.ch8_5.service;

import com.example.ch8_5.to.BoardTo;

import java.util.ArrayList;
import java.util.Map;

public interface BoardService {
    ArrayList<BoardTo> findBoardAll();

    BoardTo findBoardByBno(int bno);

    void registerBoard(BoardTo boardTo);

    void modifyBoard(Map<String, Object> map);

    void concealBoard(Map<String, Object> map);

    void removeBoard(BoardTo boardTo);
}
