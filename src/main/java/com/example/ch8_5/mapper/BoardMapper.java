package com.example.ch8_5.mapper;

import com.example.ch8_5.to.BoardTo;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.Map;

@Mapper
public interface BoardMapper {

    public ArrayList<BoardTo> selectBoardAll();

    public BoardTo selectBoardByBno(int bno);

    public void insertBoard(BoardTo boardTo);

    public void updateBoard(BoardTo boardTo);

    public void hideBoard(Map<String, Object>map);

    public void deleteBoard(Map<String, Object>map);

    // ✅ 🔍 게시물 검색 기능 추가
    ArrayList<BoardTo> searchBoard(String keyword);
}
