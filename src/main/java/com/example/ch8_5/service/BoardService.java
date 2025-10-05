package com.example.ch8_5.service;

import com.example.ch8_5.to.BoardTo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface BoardService {
    ArrayList<BoardTo> findBoardAll();

    BoardTo findBoardByBno(int bno);

    void registerBoard(BoardTo boardTo);

    void modifyBoard(BoardTo boardTo);

    void concealBoard(Map<String, Object> map);

    void deleteBoard(Map<String, Object> map);

    void removeBoard(BoardTo boardTo);

    // ✅ 🔍 게시물 검색 기능 추가
    List<BoardTo> searchBoard(String keyword);
}
