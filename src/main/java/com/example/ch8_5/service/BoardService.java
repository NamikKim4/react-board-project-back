package com.example.ch8_5.service;

import com.example.ch8_5.to.BoardTo;

import java.util.ArrayList;

public interface BoardService {
    ArrayList<BoardTo> findBoardAll();

    BoardTo findBoardByBno(int bno);

    void registerBoard(BoardTo boardTo);

    void modifyBoard(BoardTo boardTo);

    void concealBoard(BoardTo boardTo);

    void removeBoard(BoardTo boardTo);
}
